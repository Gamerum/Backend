package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.post.PostGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostMetadataDTO;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(uses = CommentMapper.class)
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "profile.id", target = "writerId")
    @Mapping(source = "profile.nickname", target = "writerNickname")
    @Mapping(source = "community.id", target = "communityId")
    @Mapping(source = "community.title", target = "communityName")
    PostGetDTO postToPostGetDTO(Post post);

    @Mapping(source = "profile.id", target = "writerId")
    @Mapping(source = "profile.nickname", target = "writerNickname")
    PostMetadataDTO postToPostMetadataDTO(Post post);

    Set<PostMetadataDTO> postsToPostMetadataDTOs(Set<Post> posts);
}
