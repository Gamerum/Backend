package com.gamerum.backend.usecase.service.post.impl;

import com.gamerum.backend.external.persistence.entity.Post;
import com.gamerum.backend.external.persistence.repository.PostRepository;
import com.gamerum.backend.usecase.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        if(!postRepository.existsById(post.getId())) {
            throw new RuntimeException();
        }
        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post getPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new RuntimeException();
        }
        return post.get();
    }

    @Override
    public List<Post> getAllCommunityPosts(Long communityId) {
        return postRepository.findByCommunityId(communityId);
    }

    @Override
    public List<Post> getAllProfilePosts(Long profileId) {
        return postRepository.findByProfileId(profileId);
    }

    @Override
    public Post getPostByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public List<Post> getAllTagPosts(String tag) {
        return postRepository.findByTag(tag);
    }
}
