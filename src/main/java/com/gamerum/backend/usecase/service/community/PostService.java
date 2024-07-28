package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Long communityId, PostCreateDTO postCreateDTO);
    Post updatePost(Long communityId, Long postId, PostUpdateDTO postUpdateDTO, String token);
    void deletePostById(Long communityId, Long postId, String token);
    Post getPostById(Long communityId, Long postId);
}
