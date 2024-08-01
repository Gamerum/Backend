package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommunityMemberSyncListener {
    private final ElasticsearchRepository elasticsearchRepository;

    public CommunityMemberSyncListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostPersist
    public void handleAfterCreate(CommunityMember member) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById("community", member.getCommunity().getId().toString(), CommunityDocument.class);
        communityDocument.setMemberCount(communityDocument.getMemberCount() + 1);
        elasticsearchRepository.save(communityDocument);

        ProfileDocument profileDocument = elasticsearchRepository.getById(
                "profile", member.getProfile().getId().toString(), ProfileDocument.class);
        profileDocument.getCommunityIds().add(member.getCommunity().getId().toString());
        elasticsearchRepository.save(profileDocument);
    }

    @PostRemove
    private void handleAfterDelete(CommunityMember member) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById("community", member.getCommunity().getId().toString(), CommunityDocument.class);
        communityDocument.setMemberCount(communityDocument.getMemberCount() - 1);
        elasticsearchRepository.save(communityDocument);

        ProfileDocument profileDocument = elasticsearchRepository.getById(
                "profile", member.getProfile().getId().toString(), ProfileDocument.class);
        profileDocument.getCommunityIds().remove(member.getCommunity().getId().toString());
        elasticsearchRepository.save(profileDocument);
    }
}
