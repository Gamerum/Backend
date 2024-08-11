package com.gamerum.backend.adaptor.consumer;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.DocumentIndex;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.usecase.service.recent.RecentService;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Component
public class CommunityListener {
    private final ElasticsearchRepository elasticsearchRepository;
    private final RecentService recentService;

    public CommunityListener(ElasticsearchRepository elasticsearchRepository, RecentService recentService) {
        this.elasticsearchRepository = elasticsearchRepository;
        this.recentService = recentService;
    }

    @PostPersist
    @Transactional
    public void handleAfterCreate(Community community) throws IOException {
        GameDocument game = elasticsearchRepository.getById(DocumentIndex.GAME, community.getGameId(), GameDocument.class);
        game.setCommunityCount(game.getCommunityCount() + 1);

        elasticsearchRepository.save(CommunityDocument.builder()
                .id(community.getId().toString())
                .title(community.getTitle())
                .description(community.getDescription())
                .game(game)
                .clickCount(0L)
                .memberCount(0L)
                .build());

        elasticsearchRepository.save(game);
    }

    @PostUpdate
    public void handleAfterUpdate(Community community) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById(DocumentIndex.COMMUNITY, community.getId().toString(), CommunityDocument.class);

        communityDocument.setTitle(community.getTitle());
        communityDocument.setDescription(community.getDescription());

        elasticsearchRepository.save(communityDocument);
    }

    @PostRemove
    @Transactional
    public void handleAfterDelete(Community community) throws IOException {
        GameDocument game = elasticsearchRepository.getById(DocumentIndex.GAME, community.getGameId(), GameDocument.class);
        game.setCommunityCount(game.getCommunityCount() - 1);

        elasticsearchRepository.deleteById(community.getId().toString(), DocumentIndex.COMMUNITY);
        elasticsearchRepository.save(game);
    }

    @PostLoad
    public void handleAfterLoad(Community community) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById(DocumentIndex.COMMUNITY, community.getId().toString(), CommunityDocument.class);
        communityDocument.setClickCount(communityDocument.getClickCount() + 1);
        elasticsearchRepository.save(communityDocument);

        recentService.saveLastViewedCommunityToCurrentProfile(communityDocument);
    }
}

