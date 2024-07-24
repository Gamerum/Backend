package com.gamerum.backend.adaptor.mapper.profile;

import com.gamerum.backend.adaptor.dto.user.profile.ProfileGetDTO;
import com.gamerum.backend.adaptor.dto.user.profile.ProfileMetadataDTO;
import com.gamerum.backend.adaptor.mapper.community.CommunityMapper;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CommunityMapper.class, PostMapper.class})
public interface ProfileMapper {
    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    @Mapping(source = "joinedCommunities", target = "communities")
    ProfileGetDTO profileToProfileGetDTO(Profile profile);

    ProfileMetadataDTO profileToProfileMetadataDTO(Profile profile);
}
