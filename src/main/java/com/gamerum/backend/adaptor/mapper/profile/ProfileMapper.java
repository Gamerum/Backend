package com.gamerum.backend.adaptor.mapper.profile;

import com.gamerum.backend.adaptor.dto.user.profile.ProfileGetDTO;
import com.gamerum.backend.adaptor.mapper.community.CommunityMapper;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.usecase.service.profile.ProfileService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@Mapper(uses = {CommunityMapper.class, PostMapper.class}, componentModel = "spring")
public abstract class ProfileMapper {

    @Autowired
    protected ProfileService profileService;
    @Mapping(source = "joinedCommunities", target = "firstPageCommunities")
    @Mapping(source = "posts", target = "firstPagePosts")
    public abstract ProfileGetDTO profileToProfileGetDTO(Profile profile) throws IOException;

    @AfterMapping
    protected void setNested(@MappingTarget ProfileGetDTO profileGetDTO, Profile profile) throws IOException {
        List<CommunityDocument> communities = profileService.getCommunities(profile.getId(), 0);
        List<PostDocument> posts = profileService.getPosts(profile.getId(), 0);

        profileGetDTO.setFirstPageCommunities(communities);
        profileGetDTO.setFirstPagePosts(posts);
    }
}
