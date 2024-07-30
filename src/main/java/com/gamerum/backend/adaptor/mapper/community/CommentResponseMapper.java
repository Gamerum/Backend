package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentResponseMapper {
    CommentResponseMapper INSTANCE = Mappers.getMapper(CommentResponseMapper.class);

    //@Mapping(source = "comment.id", target = "commentId")
    @Mapping(source = "profile.id", target = "writerId")
    @Mapping(source = "profile.nickname", target = "writerNickname")
    CommentResponseGetDTO commentResponseToCommentResponseGetDTO(CommentResponse commentResponse);

    List<CommentResponseGetDTO> commentResponsesToCommentResponseGetDTOs(List<CommentResponse> commentResponses);
}
