package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommunityMemberMapper {
    CommunityMemberMapper INSTANCE = Mappers.getMapper(CommunityMemberMapper.class);

    @Mapping(source = "profile.nickname", target = "nickname")
    CommunityMemberGetDTO communityMemberToCommunityMemberGetDTO(CommunityMember communityMember);

    List<CommunityMemberGetDTO> communityMembersToCommunityMemberGetDTOs(List<CommunityMember> communityMembers);
}
