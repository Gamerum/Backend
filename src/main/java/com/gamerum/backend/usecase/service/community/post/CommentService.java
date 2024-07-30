package com.gamerum.backend.usecase.service.community.post;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long communityId, Long postId, CommentCreateDTO commentCreateDTO);
    List<Comment> getPostComments(Long postId, int page, int size);
    Comment updateComment(CommentUpdateDTO commentUpdateDTO);
    void deleteComment(Long commentId);
}
