package com.gamerum.backend.usecase.service.community.post;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Post;

public interface PostService {
    Post createPost(Long communityId, PostCreateDTO postCreateDTO);
    Post updatePost(Long communityId, Long postId, PostUpdateDTO postUpdateDTO);
    void deletePostById(Long communityId, Long postId);
    Post getPostById(Long communityId, Long postId);
}
