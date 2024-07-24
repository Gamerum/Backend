package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityMetadataDTO;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CommunityMemberMapper.class, PostMapper.class})
public interface CommunityMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "posts", target = "popularPosts")
    CommunityGetDTO communityToCommunityGetDTO(Community community);

    CommunityMetadataDTO communityToCommunityMetadataDTO(Community community);
}
