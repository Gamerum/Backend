package com.gamerum.backend.usecase.service.community.post;

import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Reply;

import java.util.List;

public interface ReplyService {
    Reply createReply(Long commentId, ReplyCreateDTO replyCreateDTO);
    List<Reply> getReplies(Long commentId, int page, int size);
    Reply updateReply(ReplyUpdateDTO replyUpdateDTO);
    void deleteReply(Long replyId);
}
