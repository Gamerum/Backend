package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityMetadataDTO;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(uses = {CommunityMemberMapper.class, PostMapper.class})
public interface CommunityMapper {
    CommunityMapper INSTANCE = Mappers.getMapper(CommunityMapper.class);

    @Mapping(source = "posts", target = "popularPosts")
    CommunityGetDTO communityToCommunityGetDTO(Community community);

    @Mapping(source = "creatorProfileId", target = "createdBy")
    Community communityCreateDTOToCommunity(CommunityCreateDTO communityCreateDTO);

    CommunityMetadataDTO communityToCommunityMetadataDTO(Community community);

    List<CommunityMetadataDTO> communitiesToCommunityMetadataDTOs(List<Community> communities);
}
