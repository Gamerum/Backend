package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityMetadataDTO;
import com.gamerum.backend.external.persistence.relational.entity.Community;

import java.io.IOException;
import java.util.List;

public interface CommunityService {
    Community  getCommunity(Long communityId);
    List<Community> getAllCommunities();
    CommunityGetDTO createCommunity(CommunityCreateDTO community) throws IOException;
    Community updateCommunity(Community community);
    void deleteCommunity(Long communityId);
    Community getCommunityByTitle(String communityName);
    String getCommunityTags(Long communityId);
    List<Community> getTop5PopularCommunities();
}
