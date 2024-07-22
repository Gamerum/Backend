package com.gamerum.backend.usecase.service.comment;

import com.gamerum.backend.external.persistence.relational.entity.Comment;

public interface CommentService {
    Comment createComment(Comment comment);
    Comment getComment(Long id);
    Comment updateComment(Comment comment);
    void deleteComment(Long id);
}
