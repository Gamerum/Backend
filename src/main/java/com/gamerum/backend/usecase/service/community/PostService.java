package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Long communityId, PostCreateDTO postCreateDTO);
    Post updatePost(Long communityId, Long postId, PostUpdateDTO postUpdateDTO, String token);
    void deletePostById(Long postId);
    Post getPostById(Long postId);
    List<Post> getAllCommunityPosts(Long communityId);
    List<Post> getAllProfilePosts(Long profileId);
    Post getPostByTitle(String title);
    List<Post> getAllTagPosts(String tag);
}
