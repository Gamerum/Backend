package com.gamerum.backend.adaptor.dto.community.member;

import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityMemberUpdateDTO {
    private Long id;
    private CommunityMember.Role role;
}
