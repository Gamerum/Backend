package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PostSyncListener {
    private final ElasticsearchRepository elasticsearchRepository;

    public PostSyncListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostPersist
    @PostUpdate
    public void handleAfterSave(Post post) throws IOException {
        CommunityDocument community = elasticsearchRepository.getById(
                "community", post.getCommunity().getId().toString(), CommunityDocument.class);
        elasticsearchRepository.save(new PostDocument(post, community));
    }

    @PostRemove
    public void handleAfterDelete(Post post) throws IOException {
        elasticsearchRepository.deleteById(post.getId().toString(), "post");
    }
}
