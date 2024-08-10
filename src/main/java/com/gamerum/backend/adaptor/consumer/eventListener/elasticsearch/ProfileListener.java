package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.DocumentIndex;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class ProfileListener {

    private final ElasticsearchRepository elasticsearchRepository;

    public ProfileListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }


    @PostPersist
    public void handleAfterSave(Profile profile) throws IOException {
        elasticsearchRepository.save(ProfileDocument.builder()
                .id(profile.getId().toString())
                .nickname(profile.getNickname())
                .joinedCommunityIds(new ArrayList<>())
                .recentViewedCommunities(new LinkedList<>())
                .recentViewedPosts(new LinkedList<>())
                .build());
    }

    @PostUpdate
    public void handleAfterUpdate(Profile profile) throws IOException {
        ProfileDocument profileDocument = elasticsearchRepository.getById(
                DocumentIndex.PROFILE, profile.getId().toString(), ProfileDocument.class);

        profileDocument.setNickname(profile.getNickname());
        elasticsearchRepository.save(profileDocument);
    }
}
