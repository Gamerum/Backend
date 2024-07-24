package com.gamerum.backend.usecase.service.post;

import com.gamerum.backend.external.persistence.relational.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post updatePost(Post post);
    void deletePostById(Long postId);
    Post getPostById(Long postId);
    List<Post> getAllCommunityPosts(Long communityId);
    List<Post> getAllProfilePosts(Long profileId);
    Post getPostByTitle(String title);
    List<Post> getAllTagPosts(String tag);
}
