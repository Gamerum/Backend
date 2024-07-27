package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CommunitySyncListener {
    private final ElasticsearchRepository elasticsearchRepository;

    public CommunitySyncListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }


    @PostPersist
    @PostUpdate
    public void handleAfterSave(Community community) throws IOException {
        CommunityDocument document = new CommunityDocument(community);
        elasticsearchRepository.save(document);
    }

    @PostRemove
    public void handleAfterDelete(Community community) throws IOException {
        elasticsearchRepository.deleteById(community.getId().toString(), "community");
    }
}
