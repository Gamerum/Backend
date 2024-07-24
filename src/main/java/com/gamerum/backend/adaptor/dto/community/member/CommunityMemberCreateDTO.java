package com.gamerum.backend.adaptor.dto.community.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunityMemberCreateDTO {
    private Long profileId;
    private Long communityId;
    private Long joinedByProfileId;
}
