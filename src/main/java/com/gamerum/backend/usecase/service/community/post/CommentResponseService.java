package com.gamerum.backend.usecase.service.community.post;

import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.CommentResponse;

import java.util.List;

public interface CommentResponseService {
    CommentResponse createCommentResponse(Long commentId, CommentResponseCreateDTO commentResponseCreateDTO);
    List<CommentResponse> getCommentResponses(Long commentId, int page, int size);
    CommentResponse updateCommentResponse(CommentResponseUpdateDTO commentResponseUpdateDTO);
    void deleteCommentResponse(Long commentResponseId);
}
