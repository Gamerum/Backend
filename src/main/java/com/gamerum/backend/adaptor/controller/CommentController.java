package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentUpdateDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.community.CommentMapper;
import com.gamerum.backend.external.persistence.relational.entity.Comment;
import com.gamerum.backend.usecase.service.community.post.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities/{communityId}/posts/{postId}")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Create a new comment
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<CommentGetDTO>> createComment(@PathVariable Long communityId,
                                                                    @PathVariable Long postId,
                                                                    @RequestBody CommentCreateDTO commentCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Comment Send",
                CommentMapper.INSTANCE.commentToCommentGetDTO(commentService.createComment(communityId, postId, commentCreateDTO))),
                HttpStatus.CREATED);
    }

    // Get a comment by ID
    @GetMapping()
    public ResponseEntity<ResponseData<List<CommentGetDTO>>> getComments(
            @PathVariable Long postId,
            @RequestParam(required = false) int page,
            @RequestParam int size
    ) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Comments received.",
                CommentMapper.INSTANCE.commentsToCommentGetDTOs(
                        commentService.getPostComments(postId, page, size))),
                HttpStatus.CREATED);
    }

    // Update an existing comment
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<ResponseData<CommentGetDTO>> updateComment(@RequestBody CommentUpdateDTO commentUpdateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Comment updated",
                CommentMapper.INSTANCE.commentToCommentGetDTO(
                        commentService.updateComment(commentUpdateDTO))),
                HttpStatus.OK);
    }

    // Delete a comment by ID
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping
    public ResponseEntity<Response> deleteComment(@RequestParam Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(new Response(
                true,
                "Comment deleted"),
                HttpStatus.NO_CONTENT);
    }
}
