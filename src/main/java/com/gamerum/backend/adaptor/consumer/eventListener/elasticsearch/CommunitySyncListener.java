package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.CommunityESRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class CommunitySyncListener {
    private final CommunityESRepository communityESRepository;

    @PostPersist
    @PostUpdate
    public void handleAfterSave(Community community) {
        CommunityDocument document = new CommunityDocument(community);
        communityESRepository.save(document);
    }

    @PostRemove
    public void handleAfterDelete(Community community) {
        communityESRepository.deleteById(community.getId().toString());
    }
}
