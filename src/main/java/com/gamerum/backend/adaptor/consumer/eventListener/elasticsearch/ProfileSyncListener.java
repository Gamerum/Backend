package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProfileSyncListener {

    private final ElasticsearchClient elasticsearchClient;

    public ProfileSyncListener(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    @PostUpdate
    @PostPersist
    public void handleAfterSave(Profile profile) throws IOException {
        ProfileDocument document = new ProfileDocument(profile);
        IndexRequest<ProfileDocument> indexRequest = IndexRequest.of(i -> i
                .index("profile")
                .id(document.getId())
                .document(document));

        elasticsearchClient.index(indexRequest);
    }
}
