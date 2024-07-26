package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CommunitySyncListener {
    private final ElasticsearchClient elasticsearchClient;

    public CommunitySyncListener(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @PostPersist
    @PostUpdate
    public void handleAfterSave(Community community) throws IOException {
        CommunityDocument document = new CommunityDocument(community);
        IndexRequest<CommunityDocument> indexRequest = IndexRequest.of(i -> i
                .index("community")
                .id(document.getId())
                .document(document));

        elasticsearchClient.index(indexRequest);
    }

    @PostRemove
    public void handleAfterDelete(Community community) throws IOException {
        DeleteRequest deleteRequest = DeleteRequest.of(d -> d
                .index("community")
                .id(String.valueOf(community.getId()))
        );

        elasticsearchClient.delete(deleteRequest);
    }
}
