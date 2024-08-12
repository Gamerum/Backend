package com.gamerum.backend.adaptor.consumer;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.DocumentIndex;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.community.CommunityMember;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;

import java.io.IOException;

public class CommunityMemberListener {
    private final ElasticsearchRepository elasticsearchRepository;

    public CommunityMemberListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostPersist
    public void handleAfterCreate(CommunityMember member) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById(DocumentIndex.COMMUNITY, member.getCommunity().getId().toString(), CommunityDocument.class);
        communityDocument.setMemberCount(communityDocument.getMemberCount() + 1);
        elasticsearchRepository.save(communityDocument);

        ProfileDocument profileDocument = elasticsearchRepository.getById(
                DocumentIndex.PROFILE, member.getProfile().getId().toString(), ProfileDocument.class);
        profileDocument.getJoinedCommunityIds().add(member.getCommunity().getId().toString());
        elasticsearchRepository.save(profileDocument);
    }

    @PostRemove
    private void handleAfterDelete(CommunityMember member) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById(DocumentIndex.COMMUNITY, member.getCommunity().getId().toString(), CommunityDocument.class);
        communityDocument.setMemberCount(communityDocument.getMemberCount() - 1);
        elasticsearchRepository.save(communityDocument);

        ProfileDocument profileDocument = elasticsearchRepository.getById(
                DocumentIndex.PROFILE, member.getProfile().getId().toString(), ProfileDocument.class);
        profileDocument.getJoinedCommunityIds().remove(member.getCommunity().getId().toString());
        elasticsearchRepository.save(profileDocument);
    }
}
