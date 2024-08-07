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
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Component
public class CommunityListener {
    private final ElasticsearchRepository elasticsearchRepository;

    public CommunityListener(ElasticsearchRepository elasticsearchRepository) {
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @PostPersist
    @Transactional
    public void handleAfterCreate(Community community) throws IOException {
        GameDocument game = elasticsearchRepository.getById("game", community.getGameId(), GameDocument.class);
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
                .getById("community", community.getId().toString(), CommunityDocument.class);

        communityDocument.setTitle(community.getTitle());
        communityDocument.setDescription(community.getDescription());

        elasticsearchRepository.save(communityDocument);
    }

    @PostRemove
    @Transactional
    public void handleAfterDelete(Community community) throws IOException {
        GameDocument game = elasticsearchRepository.getById("game", community.getGameId(), GameDocument.class);
        game.setCommunityCount(game.getCommunityCount() - 1);

        elasticsearchRepository.deleteById(community.getId().toString(), "community");
        elasticsearchRepository.save(game);
    }

    @PostLoad
    public void handleAfterLoad(Community community) throws IOException {
        CommunityDocument communityDocument = elasticsearchRepository
                .getById("community", community.getId().toString(), CommunityDocument.class);
        communityDocument.setClickCount(communityDocument.getClickCount() + 1);
        elasticsearchRepository.save(communityDocument);
    }
}

