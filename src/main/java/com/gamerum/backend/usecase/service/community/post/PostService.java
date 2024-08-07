package com.gamerum.backend.usecase.service.community.post;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Post;

import java.io.IOException;

public interface PostService {
    Post createPost(Long communityId, PostCreateDTO postCreateDTO);
    Post updatePost(Long postId, PostUpdateDTO postUpdateDTO);
    void deletePostById(Long postId);
    Post getPostById(Long postId);
    void resetPostsClickCounts() throws IOException;
}
