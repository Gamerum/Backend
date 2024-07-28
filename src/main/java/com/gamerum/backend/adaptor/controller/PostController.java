package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
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

    // Create a new post
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

    // Update an existing post
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

    // Delete a post by ID
    @DeleteMapping("/{id}")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<Void> deletePostById(@PathVariable Long postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a post by ID
    @GetMapping("/public/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.NO_CONTENT);
    }

    // Get all posts in a community by community ID
    @GetMapping("/public/community/{communityId}")
    public ResponseEntity<List<Post>> getAllCommunityPosts(@PathVariable Long communityId) {
        return new ResponseEntity<>(postService.getAllCommunityPosts(communityId), HttpStatus.OK);
    }

    // Get all posts by a profile by profile ID
    @GetMapping("/public/profile/{profileId}")
    public ResponseEntity<List<Post>> getAllProfilePosts(@PathVariable Long profileId) {
        return new ResponseEntity<>(postService.getAllProfilePosts(profileId), HttpStatus.OK);
    }

    // Get a post by title
    @GetMapping("/public/title/{title}")
    public ResponseEntity<Post> getPostByTitle(@PathVariable String title) {
        return new ResponseEntity<>(postService.getPostByTitle(title), HttpStatus.OK);
    }

    // Get all posts with a specific tag
    @GetMapping("/public/tag/{tag}")
    public ResponseEntity<List<Post>> getAllTagPosts(@PathVariable String tag) {
        return new ResponseEntity<>(postService.getAllTagPosts(tag), HttpStatus.OK);
    }
}

