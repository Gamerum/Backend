package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PostListener {
    private final ElasticsearchRepository elasticsearchRepository;

    public PostListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostPersist
    public void handleAfterCreate(Post post) throws IOException {
        CommunityDocument community = elasticsearchRepository.getById(
                "community", post.getCommunity().getId().toString(), CommunityDocument.class);

        ProfileDocument profile = elasticsearchRepository.getById(
                "profile", post.getProfile().getId().toString(), ProfileDocument.class);

        elasticsearchRepository.save(PostDocument.builder()
                .id(post.getId().toString())
                .text(post.getText())
                .title(post.getTitle())
                .tag(post.getTag())
                .community(community)
                .profile(profile)
                .clickCount(0L)
                .createdDate(post.getCreatedDate())
                .build());
    }

    @PostUpdate
    public void handleAfterUpdate(Post post) throws IOException {
        PostDocument postDocument = elasticsearchRepository.getById(
                "post", post.getId().toString(), PostDocument.class);

        postDocument.setText(post.getText());
        postDocument.setTitle(post.getTitle());
        elasticsearchRepository.save(postDocument);
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
