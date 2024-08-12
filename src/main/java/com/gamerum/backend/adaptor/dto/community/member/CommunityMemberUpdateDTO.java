package com.gamerum.backend.adaptor.dto.community.member;

import com.gamerum.backend.external.persistence.relational.entity.community.CommunityMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityMemberUpdateDTO {
    private CommunityMember.Role role;
}
