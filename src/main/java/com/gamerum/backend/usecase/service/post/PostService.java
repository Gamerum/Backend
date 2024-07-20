package com.gamerum.backend.usecase.service.post;

import com.gamerum.backend.external.persistence.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post updatePost(Post post);
    void deletePostById(Long id);
    Post getPostById(Long id);
    List<Post> getAllCommunityPosts(Long id);
    List<Post> getAllProfilePosts(Long id);
    Post getPostByTitle(String title);
    List<Post> getAllTagPosts(String tag);
}
