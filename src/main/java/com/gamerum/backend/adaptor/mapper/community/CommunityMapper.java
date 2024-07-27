package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityMetadataDTO;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@Mapper(uses = {CommunityMemberMapper.class, PostMapper.class}, componentModel = "spring")
public abstract class CommunityMapper {
    public static CommunityMapper INSTANCE = Mappers.getMapper(CommunityMapper.class);

    @Autowired
    private ElasticsearchRepository elasticsearchRepository;

    @Mapping(source = "posts", target = "popularPosts")
    public abstract CommunityGetDTO communityToCommunityGetDTO(Community community);

    @Mapping(source = "creatorProfileId", target = "createdBy")
    public abstract Community communityCreateDTOToCommunity(CommunityCreateDTO communityCreateDTO);

    public abstract CommunityMetadataDTO communityToCommunityMetadataDTO(Community community);

    public abstract List<CommunityMetadataDTO> communitiesToCommunityMetadataDTOs(List<Community> communities);

    @AfterMapping
    protected void setGameDocument(@MappingTarget CommunityGetDTO communityGetDTO, Community community) throws IOException {
        GameDocument game = elasticsearchRepository.getById(
                "game",
                community.getGameId(),
                GameDocument.class);
        communityGetDTO.setGame(game);
    }
}
