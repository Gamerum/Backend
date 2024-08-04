package com.gamerum.backend.adaptor.controller.community;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.usecase.service.community.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/communities/{communityId}/posts")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<PostGetDTO> createPost(@PathVariable Long communityId, @RequestBody PostCreateDTO postCreateDTO) {
        return new ResponseEntity<>(postMapper.postToPostGetDTO(postService.createPost(communityId, postCreateDTO)), HttpStatus.CREATED);
    }

    @PutMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<PostGetDTO> updatePost(@RequestParam Long postId, @RequestBody PostUpdateDTO postUpdateDTO) {
        return new ResponseEntity<>(postMapper.postToPostGetDTO(postService.updatePost(postId, postUpdateDTO)), HttpStatus.OK);
    }

    @DeleteMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity deletePost(@RequestParam Long postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostGetDTO> getPost(@PathVariable Long postId) {
        return new ResponseEntity<>(postMapper.postToPostGetDTO(postService.getPostById(postId)), HttpStatus.OK);
    }
}

