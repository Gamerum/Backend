package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.relational.entity.Post;
import com.gamerum.backend.usecase.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Create a new post
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }

    // Update an existing post
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
    }

    // Delete a post by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

    // Get a post by ID
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.NO_CONTENT);
    }

    // Get all posts in a community by community ID
    @GetMapping("/community/{communityId}")
    public ResponseEntity<List<Post>> getAllCommunityPosts(@PathVariable Long communityId) {
        return new ResponseEntity<>(postService.getAllCommunityPosts(communityId), HttpStatus.OK);
    }

    // Get all posts by a profile by profile ID
    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<Post>> getAllProfilePosts(@PathVariable Long profileId) {
        return new ResponseEntity<>(postService.getAllProfilePosts(profileId), HttpStatus.OK);
    }

    // Get a post by title
    @GetMapping("/title/{title}")
    public ResponseEntity<Post> getPostByTitle(@PathVariable String title) {
        return new ResponseEntity<>(postService.getPostByTitle(title), HttpStatus.OK);
    }

    // Get all posts with a specific tag
    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<Post>> getAllTagPosts(@PathVariable String tag) {
        return new ResponseEntity<>(postService.getAllTagPosts(tag), HttpStatus.OK);
    }
}

