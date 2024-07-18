package com.gamerum.backend.usecase.service.Impl;

import com.gamerum.backend.external.persistence.entity.Post;
import com.gamerum.backend.external.persistence.repository.PostRepository;
import com.gamerum.backend.usecase.service.PostService;
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
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new RuntimeException();
        }
        return post.get();
    }

    @Override
    public List<Post> getAllCommunityPosts(Long id) {
        return postRepository.findByCommunityId(id);
    }

    @Override
    public List<Post> getAllProfilePosts(Long id) {
        return postRepository.findByProfileId(id);
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
