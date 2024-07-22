package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.relational.entity.Comment;
import com.gamerum.backend.usecase.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Create a new comment
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentService.createComment(comment), HttpStatus.CREATED);
    }

    // Get a comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.getComment(id), HttpStatus.CREATED);
    }

    // Update an existing comment
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setId(id);
        return new ResponseEntity<>(commentService.updateComment(comment),HttpStatus.OK);
    }

    // Delete a comment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
