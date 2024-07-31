package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommunityMemberCountSyncListener{
    private final ElasticsearchRepository elasticsearchRepository;

    public CommunityMemberCountSyncListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostPersist
    public void handleAfterCreate(CommunityMember member) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById("community", member.getCommunity().getId().toString(), CommunityDocument.class);
        communityDocument.setMemberCount(communityDocument.getMemberCount() + 1);
        elasticsearchRepository.save(communityDocument);
    }

    @PostRemove
    private void handleAfterDelete(CommunityMember member) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById("community", member.getCommunity().getId().toString(), CommunityDocument.class);
        communityDocument.setMemberCount(communityDocument.getMemberCount() - 1);
        elasticsearchRepository.save(communityDocument);
    }


}
