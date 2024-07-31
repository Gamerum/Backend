package com.gamerum.backend.usecase.service.community.post.impl;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.external.persistence.relational.entity.*;
import com.gamerum.backend.external.persistence.relational.repository.*;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.community.post.PostService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    @Value("${page.post.init_comment_size}")
    private int initCommentSize;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private CommunityMemberRepository communityMemberRepository;

    @Autowired
    private CurrentUser currentUser;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Post createPost(Long communityId, PostCreateDTO postCreateDTO) {
        Community community = communityRepository
                .findById(communityId)
                .orElseThrow(() -> new NotFoundException("Community"));

        Profile profile = profileRepository
                .findById(currentUser.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (!communityMemberRepository.existsByProfileIdAndCommunityId(community.getId(), profile.getId()))
            throw new NotParticipatedException();

        Post newPost = PostMapper.INSTANCE.postCreateDTOToPost(postCreateDTO);

        newPost.setCommunity(community);
        newPost.setProfile(profile);

        return postRepository.save(newPost);
    }

    @Override
    public Post updatePost(Long postId, PostUpdateDTO postUpdateDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post"));

        if(!Objects.equals(post.getProfile().getId(), currentUser.getProfileId()))
            throw new NotAllowedException();

        post.setTitle(postUpdateDTO.getTitle());
        post.setTag(postUpdateDTO.getTag());
        post.setText(postUpdateDTO.getText());

        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        if (currentUser.hasRole(UserRole.ROLE_ADMIN)) {
            postRepository.deleteById(postId);
            return;
        }

        Long profileId = currentUser.getProfileId();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post"));

        if (Objects.equals(post.getProfile().getId(), profileId)) {
            postRepository.delete(post);
            return;
        }

        CommunityMember deleter = communityMemberRepository
                .findByProfileIdAndCommunityId(profileId, post.getCommunity().getId())
                .orElseThrow(() -> new NotFoundException("Member"));

        if (deleter.getRole() == CommunityMember.Role.USER)
            throw new NotAllowedException();

        postRepository.deleteById(postId);
    }

    @Override
    public Post getPostById( Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post"));

        List<Comment> comments = commentRepository.findByPostIdOrderByCreatedDateAsc(postId, Pageable.ofSize(initCommentSize));
        post.setComments(comments);

        return post;
    }
}
