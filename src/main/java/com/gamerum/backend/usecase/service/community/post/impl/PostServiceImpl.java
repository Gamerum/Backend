package com.gamerum.backend.usecase.service.community.post.impl;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.external.cache.utils.CacheUtils;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.relational.entity.*;
import com.gamerum.backend.external.persistence.relational.repository.*;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.ParticipationException;
import com.gamerum.backend.usecase.exception.UnauthorizedException;
import com.gamerum.backend.usecase.service.community.post.PostService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    @Value("${cache.config.data.popular.cache_name}")
    private String popularCacheName;

    @Value("${cache.config.data.popular.keys.post}")
    private String popularPostCacheKey;

    @Value("${page.post.init_comment_size}")
    private int initCommentSize;

    private final PostRepository postRepository;
    private final CommunityRepository communityRepository;
    private final ProfileRepository profileRepository;
    private final CommunityMemberRepository communityMemberRepository;
    private final CurrentUser currentUser;
    private final CommentRepository commentRepository;
    private final CacheUtils cacheUtils;

    public PostServiceImpl(PostRepository postRepository,
                           CommunityRepository communityRepository,
                           ProfileRepository profileRepository,
                           CommunityMemberRepository communityMemberRepository,
                           CurrentUser currentUser, CommentRepository commentRepository,
                           CacheUtils cacheUtils) {
        this.postRepository = postRepository;
        this.communityRepository = communityRepository;
        this.profileRepository = profileRepository;
        this.communityMemberRepository = communityMemberRepository;
        this.currentUser = currentUser;
        this.commentRepository = commentRepository;
        this.cacheUtils = cacheUtils;
    }

    @Override
    public Post createPost(Long communityId, PostCreateDTO postCreateDTO) {
        Community community = communityRepository
                .findById(communityId)
                .orElseThrow(() -> new NotFoundException(Community.class));

        Profile profile = profileRepository
                .findById(currentUser.getProfileId())
                .orElseThrow(() -> new NotFoundException(Profile.class));

        if (!communityMemberRepository.existsByProfileIdAndCommunityId(profile.getId(), communityId))
            throw new ParticipationException(false);

        Post newPost = PostMapper.INSTANCE.postCreateDTOToPost(postCreateDTO);

        newPost.setCommunity(community);
        newPost.setProfile(profile);

        return postRepository.save(newPost);
    }

    @Override
    public Post updatePost(Long postId, PostUpdateDTO postUpdateDTO) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(Post.class));

        if (!post.getProfile().getId().equals(currentUser.getProfileId()))
            throw new UnauthorizedException();

        post.setTitle(postUpdateDTO.getTitle());
        post.setTag(postUpdateDTO.getTag());
        post.setText(postUpdateDTO.getText());

        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(Post.class));

        Long profileId = currentUser.getProfileId();

        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isDeleteOwnedPost = post.getProfile().getId().equals(profileId);

        if (!isAdmin && !isDeleteOwnedPost) {
            CommunityMember deleter = communityMemberRepository
                    .findByProfileIdAndCommunityId(profileId, post.getCommunity().getId())
                    .orElseThrow(() -> new NotFoundException(CommunityMember.class));

            if (deleter.getRole() == CommunityMember.Role.USER)
                throw new UnauthorizedException();
        }

        cacheUtils.invalidateCacheListIfConditionMet(popularCacheName, popularPostCacheKey,
                PostDocument.class, cachedPosts -> cachedPosts.stream()
                        .anyMatch(postDocument -> Objects.equals(postDocument.getId(), postId.toString())));

        postRepository.deleteById(postId);
    }

    @Override
    public Post getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException(Post.class));
        List<Comment> comments = commentRepository
                .findByPostIdOrderByCreatedDateAsc(postId, Pageable.ofSize(initCommentSize));
        post.setComments(comments);
        return post;
    }
}
