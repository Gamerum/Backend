package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import com.gamerum.backend.external.persistence.relational.repository.PostRepository;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PostSyncListener {
    private final ElasticsearchRepository elasticsearchRepository;
    private final PostRepository postRepository;

    public PostSyncListener(ElasticsearchRepository elasticsearchRepository, PostRepository postRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
        this.postRepository = postRepository;
    }

    @PostPersist
    @PostUpdate
    public void handleAfterSave(Post post) throws IOException {
        CommunityDocument community = elasticsearchRepository.getById(
                "community", post.getCommunity().getId().toString(), CommunityDocument.class);
        elasticsearchRepository.save(PostDocument.builder()
                .id(post.getId().toString())
                .text(post.getText())
                .title(post.getTitle())
                .clickCount(0L)
                .createdDate(post.getCreatedDate())
                .build());
    }

    @PostRemove
    public void handleAfterDelete(Post post) throws IOException {
        elasticsearchRepository.deleteById(post.getId().toString(), "post");
    }

    @PostLoad
    public void handleAfterLoad(Post post) throws IOException {
        PostDocument postDocument = elasticsearchRepository
                .getById("post", post.getId().toString(), PostDocument.class);
        postDocument.setClickCount(postDocument.getClickCount() + 1);
        elasticsearchRepository.save(postDocument);
    }
}
