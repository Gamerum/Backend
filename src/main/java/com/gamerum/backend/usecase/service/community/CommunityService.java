package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.external.persistence.entity.Community;

import java.util.List;

public interface CommunityService {
    Community  getCommunity(Long communityId);
    List<Community> getAllCommunities();
    Community createCommunity(Community community);
    Community updateCommunity(Community community);
    void deleteCommunity(Long communityId);
    Community getCommunityByTitle(String communityName);
    String getCommunityTags(Long communityId);
    List<Community> getTop5PopularCommunities();
}
