package com.gamerum.backend.adaptor.controller.community;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.CommentMapper;
import com.gamerum.backend.usecase.service.community.post.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<CommentGetDTO> createComment(@PathVariable Long postId, @Validated @RequestBody CommentCreateDTO commentCreateDTO) {
        return new ResponseEntity<>(CommentMapper.INSTANCE.commentToCommentGetDTO(commentService.createComment(postId, commentCreateDTO)), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CommentGetDTO>> getComments(@PathVariable Long postId, @RequestParam(defaultValue = "0") Integer page) {
        return new ResponseEntity<>(CommentMapper.INSTANCE.commentsToCommentGetDTOs(commentService.getPostComments(postId, page)), HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<CommentGetDTO> updateComment(@Validated @RequestBody CommentUpdateDTO commentUpdateDTO) {
        return new ResponseEntity<>(CommentMapper.INSTANCE.commentToCommentGetDTO(commentService.updateComment(commentUpdateDTO)), HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping
    public ResponseEntity deleteComment(@RequestParam Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
