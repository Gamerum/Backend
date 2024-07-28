package com.gamerum.backend.usecase.service.community.impl;

import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    private ElasticsearchRepository elasticsearchRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Post createPost(Long communityId, PostCreateDTO postCreateDTO) {
        Community community = communityRepository
                .findById(communityId)
                .orElseThrow(() -> new NotFoundException("Community"));

        Profile profile = profileRepository
                .findById(postCreateDTO.getWriterProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (!communityMemberRepository.existsByProfileIdAndCommunityId(community.getId(), profile.getId()))
            throw new NotParticipatedException();

        Post newPost = PostMapper.INSTANCE.postCreateDTOToPost(postCreateDTO);

        newPost.setCommunity(community);
        newPost.setProfile(profile);

        return postRepository.save(newPost);
    }

    @Override
    public Post updatePost(Long communityId, Long postId, PostUpdateDTO postUpdateDTO, String token) {
        Post post = postRepository.findByIdAndCommunityId(postId, communityId)
                .orElseThrow(() -> new NotFoundException("Post"));

        if(!Objects.equals(post.getProfile().getId(), jwtUtil.getProfileIdFromToken(token)))
            throw new NotAllowedException();

        post.setTitle(postUpdateDTO.getTitle());
        post.setTag(postUpdateDTO.getTag());
        post.setText(postUpdateDTO.getText());

        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long communityId, Long postId, String token) {
        if (jwtUtil.hasRole(token, UserRole.ROLE_ADMIN)) {
            postRepository.deleteById(postId);
            return;
        }

        Long profileId = jwtUtil.getProfileIdFromToken(token);

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
