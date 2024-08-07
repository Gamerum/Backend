package com.gamerum.backend.usecase.service.community.impl;

import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.UpdateByQueryRequest;
import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityUpdateDTO;
import com.gamerum.backend.adaptor.dto.community.post.CommunityUpdateTagsDTO;
import com.gamerum.backend.adaptor.mapper.community.CommunityMapper;
import com.gamerum.backend.external.cache.utils.CacheUtils;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.UnauthorizedException;
import com.gamerum.backend.usecase.service.community.CommunityService;
import com.gamerum.backend.usecase.service.community.CommunityTagService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Value("${cache.config.data.popular.cache_name}")
    private String popularCacheName;

    @Value("${cache.config.data.popular.keys.community}")
    private String popularCommunityCacheKey;

    @Value("${page.community.init_member_size}")
    private int initMemberSize;

    private final CommunityRepository communityRepository;
    private final CommunityMemberRepository communityMemberRepository;
    private final ProfileRepository profileRepository;
    private final CommunityMapper communityMapper;
    private final CurrentUser currentUser;
    private final CacheUtils cacheUtils;
    private final CommunityTagService communityTagService;
    private final ElasticsearchRepository elasticsearchRepository;

    public CommunityServiceImpl(CommunityRepository communityRepository,
                                CommunityMemberRepository communityMemberRepository,
                                ProfileRepository profileRepository,
                                CommunityMapper communityMapper,
                                CurrentUser currentUser,
                                CacheUtils cacheUtils,
                                CommunityTagService communityTagService, ElasticsearchRepository elasticsearchRepository) {
        this.communityRepository = communityRepository;
        this.communityMemberRepository = communityMemberRepository;
        this.profileRepository = profileRepository;
        this.communityMapper = communityMapper;
        this.currentUser = currentUser;
        this.cacheUtils = cacheUtils;
        this.communityTagService = communityTagService;
        this.elasticsearchRepository = elasticsearchRepository;
    }

    @Override
    public Community getCommunity(Long communityId) {
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new NotFoundException(Community.class));

        List<CommunityMember> members = communityMemberRepository
                .findByCommunityIdOrderByRoleAsc(communityId, Pageable.ofSize(initMemberSize));
        community.setMembers(members);
        return community;
    }

    @Override
    @Transactional
    public Community createCommunity(CommunityCreateDTO communityCreateDTO) {
        Community community = communityMapper.communityCreateDTOToCommunity(communityCreateDTO);
        community.setTags("Popular");
        community = communityRepository.save(community);
        saveCreator(community);
        return community;
    }

    private void saveCreator(Community newCommunity) {
        Profile creatorProfile = profileRepository.findById(currentUser.getProfileId())
                .orElseThrow(() -> new NotFoundException(Profile.class));

        CommunityMember creator = CommunityMember.builder()
                .profile(creatorProfile)
                .community(newCommunity)
                .role(CommunityMember.Role.OWNER)
                .build();

        newCommunity.setMembers(List.of(communityMemberRepository.save(creator)));
    }

    @Override
    public Community updateCommunity(Long communityId, CommunityUpdateDTO communityUpdateDTO) {
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new NotFoundException(Community.class));

        CommunityMember updater = communityMemberRepository
                .findByProfileIdAndCommunityId(currentUser.getProfileId(), communityId)
                .orElseThrow(() -> new NotFoundException(CommunityMember.class));

        if (updater.getRole() == CommunityMember.Role.USER) throw new UnauthorizedException();

        community.setTitle(communityUpdateDTO.getTitle());
        community.setDescription(communityUpdateDTO.getDescription());

        return communityRepository.save(community);
    }

    @Override
    public void deleteCommunity(Long communityId) {
        if (!currentUser.hasRole(UserRole.ROLE_ADMIN)) {
            CommunityMember deleter = communityMemberRepository
                    .findByProfileIdAndCommunityId(currentUser.getProfileId(), communityId)
                    .orElseThrow(() -> new NotFoundException(CommunityMember.class));

            if (deleter.getRole() != CommunityMember.Role.OWNER) throw new UnauthorizedException();
        }

        cacheUtils.invalidateCacheListIfConditionMet(popularCacheName, popularCommunityCacheKey,
                CommunityDocument.class, cachedCommunities -> cachedCommunities.stream()
                        .anyMatch(community -> Objects.equals(community.getId(), communityId.toString())));

        communityRepository.deleteById(communityId);
    }

    @Override
    public List<String> updateTagsToCommunity(Long communityId, CommunityUpdateTagsDTO communityUpdateTagsDTO) {
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new NotFoundException(Community.class));

        CommunityMember adder = communityMemberRepository
                .findByProfileIdAndCommunityId(currentUser.getProfileId(), communityId)
                .orElseThrow(() -> new NotFoundException(CommunityMember.class));

        if (adder.getRole() == CommunityMember.Role.USER) throw new UnauthorizedException();

        String newTagsString = communityUpdateTagsDTO.isRemove() ?
                communityTagService.removeTags(community, communityUpdateTagsDTO.getTags()) :
                communityTagService.addTags(community, communityUpdateTagsDTO.getTags());

        if (newTagsString != null) {
            community.setTags(newTagsString);
            community = communityRepository.save(community);
        }

        return Arrays.stream(community.getTags().split(",")).toList();
    }

    public void resetCommunitiesClickCount() throws IOException {
        UpdateByQueryRequest request = UpdateByQueryRequest.of(ubq -> ubq
                .index("community")
                .script(s -> s .inline(i -> i .source("ctx._source.clickCount = 0")))
                .query(QueryBuilders.matchAll().build()._toQuery())
        );

        elasticsearchRepository.updateByRequest(request);
    }
}
