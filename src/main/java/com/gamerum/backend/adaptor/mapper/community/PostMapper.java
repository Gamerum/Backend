package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = CommentMapper.class, componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "profile.id", target = "writerId")
    @Mapping(source = "profile.nickname", target = "writerNickname")
    @Mapping(source = "community.id", target = "communityId")
    @Mapping(source = "community.title", target = "communityName")
    @Mapping(source = "comments", target = "firstPageComments")
    PostGetDTO postToPostGetDTO(Post post);


    Post postCreateDTOToPost(PostCreateDTO postCreateDTO);
}
