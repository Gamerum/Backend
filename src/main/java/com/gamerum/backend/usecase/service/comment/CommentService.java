package com.gamerum.backend.usecase.service.comment;

import com.gamerum.backend.external.persistence.entity.Comment;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment getComment(Long commentId);
    Comment updateComment(Comment comment);
    void deleteComment(Long commentId);
}
