package com.gamerum.backend.adaptor.controller;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentUpdateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseUpdateDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.community.CommentMapper;
import com.gamerum.backend.adaptor.mapper.community.CommentResponseMapper;
import com.gamerum.backend.usecase.service.community.post.CommentResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments/{commentId}/response")
public class CommentResponseController {

    @Autowired
    private CommentResponseService commentResponseService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<CommentResponseGetDTO>> createCommentResponse(
            @PathVariable Long commentId,
            @RequestBody CommentResponseCreateDTO commentResponseCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Comment Response Send",
                CommentResponseMapper.INSTANCE.commentResponseToCommentResponseGetDTO(
                        commentResponseService.createCommentResponse(commentId, commentResponseCreateDTO))),
                HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ResponseData<List<CommentResponseGetDTO>>> getCommentResponses(
            @PathVariable Long commentId,
            @RequestParam(required = false) int page,
            @RequestParam int size
    ) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Comment Responses received.",
                CommentResponseMapper.INSTANCE.commentResponsesToCommentResponseGetDTOs(
                        commentResponseService.getCommentResponses(commentId, page, size))),
                HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<ResponseData<CommentResponseGetDTO>> updateCommentResponse(@RequestBody CommentResponseUpdateDTO commentResponseUpdateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Comment Response updated",
                CommentResponseMapper.INSTANCE.commentResponseToCommentResponseGetDTO(
                        commentResponseService.updateCommentResponse(commentResponseUpdateDTO))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping
    public ResponseEntity<Response> deleteCommentResponse(@RequestParam Long commentId) {
        commentResponseService.deleteCommentResponse(commentId);
        return new ResponseEntity<>(new Response(
                true,
                "Comment Response deleted"),
                HttpStatus.NO_CONTENT);
    }
}
