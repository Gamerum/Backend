package com.gamerum.backend.adaptor.dto.community.member;

import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunityMemberUpdateDTO {
    private Long id;
    private CommunityMember.Role role;
    private Long updaterId;
}
