package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CommunitySyncListener{
    private final ElasticsearchRepository elasticsearchRepository;

    public CommunitySyncListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostPersist
    public void handleAfterCreate(Community community) throws IOException {
        GameDocument game = elasticsearchRepository.getById("game", community.getGameId(), GameDocument.class);
        elasticsearchRepository.save(CommunityDocument.builder()
                .id(community.getId().toString())
                .title(community.getTitle())
                .description(community.getDescription())
                .game(game)
                .clickCount(0L)
                .memberCount(0L)
                .build());
    }

    @PostUpdate
    public void handleAfterUpdate(Community community) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById("community", community.getId().toString(), CommunityDocument.class);

        communityDocument.setTitle(community.getTitle());
        communityDocument.setDescription(community.getDescription());

        elasticsearchRepository.save(communityDocument);
    }

    @PostRemove
    public void handleAfterDelete(Community community) throws IOException {
        elasticsearchRepository.deleteById(community.getId().toString(), "community");
    }

    @PostLoad
    public void handleAfterLoad(Community community) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById("community", community.getId().toString(), CommunityDocument.class);
        communityDocument.setClickCount(communityDocument.getClickCount() + 1);
        elasticsearchRepository.save(communityDocument);
    }
}

