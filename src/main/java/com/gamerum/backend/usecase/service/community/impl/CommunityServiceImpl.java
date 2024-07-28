package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.CommunityMapper;
import com.gamerum.backend.external.cache.utils.CacheUtils;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@CacheConfig(cacheNames = "${cache.config.data.community.cache_name}")
public class CommunityServiceImpl implements CommunityService {
    private final String popularCommunitiesCacheKey = "'popularCommunities'";

    @Value("${cache.config.data.community.cache_name}")
    private String cacheName;

    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private CommunityMemberRepository communityMemberRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private CommunityMapper communityMapper;

    @Autowired
    private CacheUtils cacheUtils;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Community getCommunity(Long communityId) {
       return communityRepository.findById(communityId)
               .orElseThrow(() -> new NotFoundException("Community"));
    }

    @Override
    public Community createCommunity(CommunityCreateDTO communityCreateDTO) {
        Long creatorId = jwtUtil.getCurrentUserProfileId();

        Profile creatorProfile = profileRepository.findById(creatorId)
                .orElseThrow(() -> new NotFoundException("Profile"));

        Community community = communityMapper.communityCreateDTOToCommunity(communityCreateDTO);
        community = communityRepository.save(community);

        CommunityMember creator = CommunityMember.builder()
                .profile(creatorProfile)
                .community(community)
                .role(CommunityMember.Role.OWNER)
                .build();

        creator = communityMemberRepository.save(creator);

        community.setMembers(List.of(creator));

        return community;
    }

    @Override
    public Community updateCommunity(Long communityId, CommunityUpdateDTO communityUpdateDTO) {
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new NotFoundException("Community"));

        CommunityMember updater = communityMemberRepository
                .findByProfileIdAndCommunityId(jwtUtil.getCurrentUserProfileId(), communityId)
                .orElseThrow(() -> new NotFoundException("Member"));

        if (updater.getRole() == CommunityMember.Role.USER)
            throw new NotAllowedException();

        community.setTitle(communityUpdateDTO.getTitle());
        community.setDescription(communityUpdateDTO.getDescription());
        community.setTags(communityUpdateDTO.getTags());

        return communityRepository.save(community);
    }

    @Override
    public void deleteCommunity(Long communityId) {
        if (jwtUtil.currentUserHasRole(UserRole.ROLE_ADMIN)) {
            cacheUtils.invalidateCacheListIfConditionMet(cacheName, popularCommunitiesCacheKey,
                    Community.class, cachedCommunities ->
                            cachedCommunities.stream().anyMatch(community -> Objects.equals(community.getId(), communityId))
            );

            communityRepository.deleteById(communityId);
            return;
        }

        CommunityMember deleter = communityMemberRepository
                .findByProfileIdAndCommunityId(jwtUtil.getCurrentUserProfileId(), communityId)
                .orElseThrow(() -> new NotFoundException("Member"));

        if (deleter.getRole() != CommunityMember.Role.OWNER)
            throw new NotAllowedException();

        cacheUtils.invalidateCacheListIfConditionMet(cacheName, popularCommunitiesCacheKey,
                Community.class, cachedCommunities ->
                        cachedCommunities.stream().anyMatch(community -> Objects.equals(community.getId(), communityId))
        );

        communityRepository.deleteById(communityId);
    }

    //Later new Service
//    @Override
//    @Cacheable(key = popularCommunitiesCacheKey, unless = "#result == null || #result.size() == 0")
//    public List<Community> getTop5PopularCommunities() {
//        Pageable pageable = PageRequest.of(0, 5);
//        return communityRepository.findAllByOrderByClickCountDesc(pageable);
//    }
}
