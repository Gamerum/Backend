package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProfileSyncListener {

    private final ElasticsearchRepository elasticsearchRepository;

    public ProfileSyncListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostUpdate
    @PostPersist
    public void handleAfterSave(Profile profile) throws IOException {
        elasticsearchRepository.save(new ProfileDocument(profile));
    }
}
