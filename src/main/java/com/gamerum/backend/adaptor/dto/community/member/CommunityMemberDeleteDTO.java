package com.gamerum.backend.adaptor.dto.community.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityMemberDeleteDTO {
    private Long id;
    private Long deleterProfileId;
}
