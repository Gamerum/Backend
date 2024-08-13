package com.gamerum.backend.usecase.service.recent.impl;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.DocumentIndex;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.usecase.service.recent.RecentService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Queue;

@Service
public class RecentServiceImpl implements RecentService {
    private final ElasticsearchRepository elasticsearchRepository;
    private final CurrentUser currentUser;

    @Value("${panel.recent_viewed.community_size}")
    private int recentViewedCommunitySize;

    @Value("${panel.recent_viewed.post_size}")
    private int recentViewedPostSize;

    public RecentServiceImpl(ElasticsearchRepository elasticsearchRepository, CurrentUser currentUser) {
        this.elasticsearchRepository = elasticsearchRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void saveLastViewedPostToCurrentProfile(PostDocument postDocument) throws IOException {
        String currentProfileId = currentUser.getProfileId().toString();

        ProfileDocument profileDocument = elasticsearchRepository
                .getById(DocumentIndex.PROFILE, currentProfileId, ProfileDocument.class);

        ProfileDocument.ViewedPost viewedPost = new ProfileDocument.ViewedPost(
                postDocument.getId(),
                postDocument.getWriter().nickname(),
                postDocument.getCommunity().id(),
                postDocument.getCommunity().title(),
                postDocument.getTitle(),
                postDocument.getCommentCount(),
                postDocument.getLikedByProfileIds().stream().count()
        );

        Queue<ProfileDocument.ViewedPost> recentViewedPosts = profileDocument.getRecentViewedPosts();
        recentViewedPosts.removeIf(vp -> vp.id().equals(postDocument.getId()));
        recentViewedPosts.add(viewedPost);
        if (recentViewedPosts.size() > recentViewedPostSize) recentViewedPosts.poll();

        elasticsearchRepository.save(profileDocument);
    }

    @Override
    public void saveLastViewedCommunityToCurrentProfile(CommunityDocument communityDocument) throws IOException {
        String currentProfileId = currentUser.getProfileId().toString();

        ProfileDocument profileDocument = elasticsearchRepository
                .getById(DocumentIndex.PROFILE, currentProfileId, ProfileDocument.class);

        ProfileDocument.ViewedCommunity viewedCommunity = new ProfileDocument.ViewedCommunity(
                communityDocument.getId(), communityDocument.getTitle(), communityDocument.getMemberCount());

        Queue<ProfileDocument.ViewedCommunity> recentViewedCommunities = profileDocument.getRecentViewedCommunities();
        recentViewedCommunities.removeIf(vc -> vc.id().equals(communityDocument.getId()));
        recentViewedCommunities.add(viewedCommunity);
        if (recentViewedCommunities.size() > recentViewedCommunitySize) recentViewedCommunities.poll();

        elasticsearchRepository.save(profileDocument);
    }
}
