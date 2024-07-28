package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostMetadataDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import com.gamerum.backend.usecase.service.community.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities/{communityId}/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<PostGetDTO>> createPost(
            @PathVariable Long communityId,
            @RequestBody PostCreateDTO postCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Post created.",
                PostMapper.INSTANCE.postToPostGetDTO(postService.createPost(communityId, postCreateDTO))),
                HttpStatus.CREATED);
    }

    @PutMapping
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<ResponseData<PostGetDTO>> updatePost(
            @PathVariable Long communityId,
            @RequestParam Long postId,
            @RequestBody PostUpdateDTO postUpdateDTO,
            @RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Post updated.",
                PostMapper.INSTANCE.postToPostGetDTO(postService.updatePost(communityId, postId, postUpdateDTO, token))),
                HttpStatus.OK);
    }

    @DeleteMapping
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<Response> deletePostById(
            @PathVariable Long communityId,
            @RequestParam Long postId,
            @RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        postService.deletePostById(communityId, postId, token);
        return new ResponseEntity<>(new Response(
                true,
                "Post deleted."),
                HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<ResponseData<PostGetDTO>> getPostById(
            @PathVariable Long communityId,
            @PathVariable Long postId) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Post received.",
                PostMapper.INSTANCE.postToPostGetDTO(postService.getPostById(communityId, postId))),
                HttpStatus.OK);
    }
}

