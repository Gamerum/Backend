package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Community;

import java.io.IOException;

public interface CommunityService {
    Community  getCommunity(Long communityId);
    Community createCommunity(CommunityCreateDTO communityCreateDTO) throws IOException;
    Community updateCommunity(Long communityId, CommunityUpdateDTO communityUpdateDTO, String token);
    void deleteCommunity(Long communityId, String token);
    //Later new Service
    //List<Community> getTop5PopularCommunities();
}
