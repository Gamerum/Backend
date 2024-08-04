package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.usecase.service.popular.PopularService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@Mapper(uses = {CommunityMemberMapper.class, PostMapper.class}, componentModel = "spring")
public abstract class CommunityMapper {

    @Autowired
    private ElasticsearchRepository elasticsearchRepository;

    @Autowired
    private PopularService popularService;

    @Mapping(source = "posts", target = "firstPagePopularPosts")
    @Mapping(source = "members", target = "firstPageMembers")
    public abstract CommunityGetDTO communityToCommunityGetDTO(Community community) throws IOException;

    public abstract Community communityCreateDTOToCommunity(CommunityCreateDTO communityCreateDTO);

    @AfterMapping
    protected void setNestedParameters(@MappingTarget CommunityGetDTO communityGetDTO, Community community) throws IOException {
        GameDocument game = elasticsearchRepository.getById(
                "game",
                community.getGameId(),
                GameDocument.class);
        communityGetDTO.setGame(game);

        List<PostDocument> popularPosts = popularService.getCommunityPopularPosts(community.getId().toString(), 0);
        communityGetDTO.setFirstPagePopularPosts(popularPosts);
    }
}
