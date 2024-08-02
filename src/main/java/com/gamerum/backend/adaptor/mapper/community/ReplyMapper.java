package com.gamerum.backend.adaptor.mapper.community;

import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper {
    ReplyMapper INSTANCE = Mappers.getMapper(ReplyMapper.class);

    @Mapping(source = "comment.id", target = "commentId")
    @Mapping(source = "profile.id", target = "writerId")
    @Mapping(source = "profile.nickname", target = "writerNickname")
    ReplyGetDTO replyToReplyGetDTO(Reply reply);

    List<ReplyGetDTO> repliesToReplyGetDTOs(List<Reply> replies);
}