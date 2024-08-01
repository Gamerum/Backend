package com.gamerum.backend.usecase.service.community.post.impl;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.external.cache.utils.CacheUtils;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
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

    @Value("${cache.config.data.popular.cache_name}")
    private String popularCacheName;

    @Value("${cache.config.data.popular.keys.post}")
    private String popularPostCacheKey;

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

    @Autowired
    private CacheUtils cacheUtils;

    @Override
    public Post createPost(Long communityId, PostCreateDTO postCreateDTO) {
        Community community = communityRepository
                .findById(communityId)
                .orElseThrow(() -> new NotFoundException("Community"));

        Profile profile = profileRepository
                .findById(currentUser.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (!communityMemberRepository.existsByProfileIdAndCommunityId(profile.getId(), communityId))
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

        if (!Objects.equals(post.getProfile().getId(), currentUser.getProfileId()))
            throw new NotAllowedException();

        post.setTitle(postUpdateDTO.getTitle());
        post.setTag(postUpdateDTO.getTag());
        post.setText(postUpdateDTO.getText());

        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post"));

        Long profileId = currentUser.getProfileId();

        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isDeleteOwnedPost = Objects.equals(post.getProfile().getId(), profileId);

        if (!isAdmin && !isDeleteOwnedPost) {
            CommunityMember deleter = communityMemberRepository
                    .findByProfileIdAndCommunityId(profileId, post.getCommunity().getId())
                    .orElseThrow(() -> new NotFoundException("Member"));

            if (deleter.getRole() == CommunityMember.Role.USER)
                throw new NotAllowedException();
        }

        cacheUtils.invalidateCacheListIfConditionMet(popularCacheName, popularPostCacheKey,
                PostDocument.class, cachedPosts -> cachedPosts.stream()
                        .anyMatch(postDocument -> Objects.equals(postDocument.getId(), postId.toString())));

        postRepository.deleteById(postId);
    }

    @Override
    public Post getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post"));

        List<Comment> comments = commentRepository.findByPostIdOrderByCreatedDateAsc(postId, Pageable.ofSize(initCommentSize));
        post.setComments(comments);

        return post;
    }
}
