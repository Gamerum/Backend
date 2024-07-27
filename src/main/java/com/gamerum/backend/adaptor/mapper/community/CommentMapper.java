package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "responseTo.id", target = "respondCommentId")
    @Mapping(source = "profile.id", target = "writerId")
    @Mapping(source = "profile.nickname", target = "writerNickname")
    CommentGetDTO commentToCommentGetDTO(Comment comment);

    List<CommentGetDTO> commentsToCommentGetDTOs(List<Comment> comments);
}
