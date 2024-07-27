package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.adaptor.mapper.community.CommunityMapper;
import com.gamerum.backend.external.cache.utils.CacheUtils;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.usecase.service.community.CommunityMemberService;
import com.gamerum.backend.usecase.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public Community getCommunity(Long communityId) {
        Optional<Community> community = communityRepository.findById(communityId);
        if(community.isEmpty())
            throw new RuntimeException();
        return community.get();
    }

    @Override
    public List<Community> getAllCommunities() {
        return (List<Community>) communityRepository.findAll();
    }

    @Override
    public CommunityGetDTO createCommunity(CommunityCreateDTO communityCreateDTO) throws IOException {
        Optional<Profile> creatorProfile = profileRepository.findById(communityCreateDTO.getCreatorProfileId());
        if (creatorProfile.isEmpty())
            throw new RuntimeException();

        Community community = communityMapper.communityCreateDTOToCommunity(communityCreateDTO);
        community = communityRepository.save(community);

        CommunityMember creator = new CommunityMember();
        creator.setCommunity(community);
        creator.setProfile(creatorProfile.get());
        creator.setRole(CommunityMember.Role.OWNER);
        creator = communityMemberRepository.save(creator);

        community.getMembers().add(creator);

        return communityMapper.communityToCommunityGetDTO(community);
    }

    @Override
    public Community updateCommunity(Community community) {
        if (!communityRepository.existsById(community.getId())){
            throw new RuntimeException();
        }
        return communityRepository.save(community);
    }

    @Override
    public void deleteCommunity(Long communityId) {
        cacheUtils.invalidateCacheListIfConditionMet(cacheName, popularCommunitiesCacheKey,
                Community.class, cachedCommunities ->
                        cachedCommunities.stream().anyMatch(community -> Objects.equals(community.getId(), communityId))
        );

        communityRepository.deleteById(communityId);
    }

    @Override
    public Community getCommunityByTitle(String communityName) {
        return communityRepository.findByTitle(communityName);
    }

    @Override
    public String getCommunityTags(Long communityId) {
        Optional<String> optionalTags = communityRepository.findById(communityId).get().getTags().describeConstable();
        if(optionalTags.isEmpty())
            throw new RuntimeException();
        return optionalTags.get();
    }

    @Override
    @Cacheable(key = popularCommunitiesCacheKey, unless = "#result == null || #result.size() == 0")
    public List<Community> getTop5PopularCommunities() {
        Pageable pageable = PageRequest.of(0, 5);
        return communityRepository.findAllByOrderByClickCountDesc(pageable);
    }
}
