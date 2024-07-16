package com.gamerum.backend.service;

import com.gamerum.backend.entity.Community;

import java.util.List;

public interface CommunityService {
    Community  getCommunity(Long id);
    List<Community> getAllCommunities();
    Community createCommunity(Community community);
    Community updateCommunity(Community community);
    void deleteCommunity(Long id);
    Community getCommunityByTitle(String communityName);
    String getCommunityTags(Long id);
}
