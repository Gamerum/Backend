package com.gamerum.backend.adaptor.consumer;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.DocumentIndex;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.community.Post;
import com.gamerum.backend.usecase.service.recent.RecentService;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;

import java.io.IOException;
import java.util.ArrayList;

public class PostListener {
    private final ElasticsearchRepository elasticsearchRepository;
    private final RecentService recentService;

    public PostListener(ElasticsearchRepository elasticsearchRepository, RecentService recentService) {
        this.elasticsearchRepository = elasticsearchRepository;
        this.recentService = recentService;
    }

    @PostPersist
    public void handleAfterCreate(Post post) throws IOException {
        CommunityDocument community = elasticsearchRepository.getById(
                DocumentIndex.COMMUNITY, post.getCommunity().getId().toString(), CommunityDocument.class);

        ProfileDocument profile = elasticsearchRepository.getById(
                DocumentIndex.PROFILE, post.getWriter().getId().toString(), ProfileDocument.class);

        elasticsearchRepository.save(PostDocument.builder()
                .id(post.getId().toString())
                .text(post.getText())
                .title(post.getTitle())
                .tag(post.getTag())
                .community(new PostDocument.Community(community.getId(), community.getTitle()))
                .writer(new PostDocument.Profile(profile.getId(), profile.getNickname()))
                .clickCount(0L)
                .commentCount(0L)
                .likedByProfileIds(new ArrayList<>())
                .createdDate(post.getCreatedDate())
                .build());
    }

    @PostUpdate
    public void handleAfterUpdate(Post post) throws IOException {
        PostDocument postDocument = elasticsearchRepository.getById(
                DocumentIndex.POST, post.getId().toString(), PostDocument.class);

        postDocument.setText(post.getText());
        postDocument.setTitle(post.getTitle());
        elasticsearchRepository.save(postDocument);
    }

    @PostRemove
    public void handleAfterDelete(Post post) throws IOException {
        elasticsearchRepository.deleteById(post.getId().toString(), DocumentIndex.POST);
    }

    @PostLoad
    public void handleAfterLoad(Post post) throws IOException {
        PostDocument postDocument = elasticsearchRepository
                .getById(DocumentIndex.POST, post.getId().toString(), PostDocument.class);
        postDocument.setClickCount(postDocument.getClickCount() + 1);
        elasticsearchRepository.save(postDocument);

        recentService.saveLastViewedPostToCurrentProfile(postDocument);
    }
}
