package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.external.persistence.entity.CommunityMember;

import java.util.List;

public interface CommunityMemberService {
    CommunityMember createCommunityMember(CommunityMember communityMember);
    CommunityMember getCommunityMember(Long id);
    List<CommunityMember> getCommunityMembers();
    void deleteCommunityMember(Long id);
    List<CommunityMember> getCommunityMembersByCommunity(Long communityId);
    List<CommunityMember> getCommunityMembersByProfile(Long profileId);
}
