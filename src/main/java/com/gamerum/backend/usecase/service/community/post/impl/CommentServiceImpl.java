package com.gamerum.backend.usecase.service.community.post.impl;

import com.gamerum.backend.external.persistence.relational.entity.Comment;
import com.gamerum.backend.external.persistence.relational.repository.CommentRepository;
import com.gamerum.backend.usecase.service.community.post.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getComment(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isEmpty())
            throw new RuntimeException();
        return comment.get();
    }


    @Override
    public Comment updateComment(Comment comment) {
        if(commentRepository.existsById(comment.getId()))
            throw new RuntimeException();
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
