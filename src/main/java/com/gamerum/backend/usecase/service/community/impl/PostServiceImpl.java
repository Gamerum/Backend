package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.adaptor.dto.community.post.PostCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.PostUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.PostMapper;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityRepository;
import com.gamerum.backend.external.persistence.relational.repository.PostRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.community.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private CommunityMemberRepository communityMemberRepository;


    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Post createPost(Long communityId, PostCreateDTO postCreateDTO) {
        Community community = communityRepository
                .findById(communityId)
                .orElseThrow(() -> new NotFoundException("Community"));

        Profile profile = profileRepository
                .findById(jwtUtil.getCurrentUserProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (!communityMemberRepository.existsByProfileIdAndCommunityId(community.getId(), profile.getId()))
            throw new NotParticipatedException();

        Post newPost = PostMapper.INSTANCE.postCreateDTOToPost(postCreateDTO);

        newPost.setCommunity(community);
        newPost.setProfile(profile);

        return postRepository.save(newPost);
    }

    @Override
    public Post updatePost(Long communityId, Long postId, PostUpdateDTO postUpdateDTO) {
        Post post = postRepository.findByIdAndCommunityId(postId, communityId)
                .orElseThrow(() -> new NotFoundException("Post"));

        if(!Objects.equals(post.getProfile().getId(), jwtUtil.getCurrentUserProfileId()))
            throw new NotAllowedException();

        post.setTitle(postUpdateDTO.getTitle());
        post.setTag(postUpdateDTO.getTag());
        post.setText(postUpdateDTO.getText());

        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long communityId, Long postId) {
        if (jwtUtil.currentUserHasRole(UserRole.ROLE_ADMIN)) {
            postRepository.deleteById(postId);
            return;
        }

        Long profileId = jwtUtil.getCurrentUserProfileId();

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Post"));

        if (Objects.equals(post.getProfile().getId(), profileId)) {
            postRepository.delete(post);
            return;
        }

        CommunityMember deleter = communityMemberRepository
                .findByProfileIdAndCommunityId(profileId, communityId)
                .orElseThrow(() -> new NotFoundException("Member"));

        if (deleter.getRole() == CommunityMember.Role.USER)
            throw new NotAllowedException();

        postRepository.deleteById(postId);
    }

    @Override
    public Post getPostById(Long communityId, Long postId) {
        return postRepository.findByIdAndCommunityId(postId, communityId)
                .orElseThrow(() -> new NotFoundException("Post"));
    }
}
