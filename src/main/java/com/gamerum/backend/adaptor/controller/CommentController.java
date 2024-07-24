package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.relational.entity.Comment;
import com.gamerum.backend.usecase.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Create a new comment
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
    }

    // Get a comment by ID
    @GetMapping("/public/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.getComment(commentId), HttpStatus.CREATED);
    }

    // Update an existing comment
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        comment.setId(commentId);
        return new ResponseEntity<>(commentService.updateComment(comment),HttpStatus.OK);
    }

    // Delete a comment by ID
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
