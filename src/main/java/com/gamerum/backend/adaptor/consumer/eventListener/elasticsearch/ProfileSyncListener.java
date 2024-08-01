package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class ProfileSyncListener {

    private final ElasticsearchRepository elasticsearchRepository;

    public ProfileSyncListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }


    @PostPersist
    public void handleAfterSave(Profile profile) throws IOException {
        elasticsearchRepository.save(ProfileDocument.builder()
                .id(profile.getId().toString())
                .nickname(profile.getNickname())
                .communityIds(new ArrayList<>())
                .build());
    }

    @PostUpdate
    public void handleAfterUpdate(Profile profile) throws IOException {
        ProfileDocument profileDocument = elasticsearchRepository.getById(
                "profile", profile.getId().toString(), ProfileDocument.class);

        profileDocument.setNickname(profile.getNickname());
        elasticsearchRepository.save(profileDocument);
    }
}
