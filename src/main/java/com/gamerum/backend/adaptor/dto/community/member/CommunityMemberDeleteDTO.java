package com.gamerum.backend.adaptor.dto.community.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunityMemberDeleteDTO {
    private Long id;
    private Long deleterProfileId;
}
