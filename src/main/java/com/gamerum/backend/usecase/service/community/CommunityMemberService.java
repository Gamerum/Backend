package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberCreateDTO;
import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;

import java.util.List;

public interface CommunityMemberService {
    CommunityMember createCommunityMember(Long communityId, CommunityMemberCreateDTO communityMemberCreateDTO);
    List<CommunityMember> getCommunityMembers(Long communityId, int page);
    CommunityMember updateCommunityMember(CommunityMemberUpdateDTO communityMemberUpdateDTO);
    void deleteCommunityMember(Long communityId, Long profileId);
}
