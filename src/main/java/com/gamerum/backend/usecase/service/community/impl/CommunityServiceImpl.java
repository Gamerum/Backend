package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.external.cache.utils.CacheUtils;
import com.gamerum.backend.external.persistence.entity.Community;
import com.gamerum.backend.external.persistence.repository.CommunityRepository;
import com.gamerum.backend.usecase.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    private CacheUtils cacheUtils;

    @Override
    public Community getCommunity(Long id) {
        Optional<Community> community = communityRepository.findById(id);
        if(community.isEmpty())
            throw new RuntimeException();
        return community.get();
    }

    @Override
    public List<Community> getAllCommunities() {
        return (List<Community>) communityRepository.findAll();
    }

    @Override
    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }

    @Override
    public Community updateCommunity(Community community) {
        if (!communityRepository.existsById(community.getId())){
            throw new RuntimeException();
        }
        return communityRepository.save(community);
    }

    @Override
    public void deleteCommunity(Long id) {
        cacheUtils.invalidateCacheListIfConditionMet(cacheName, popularCommunitiesCacheKey,
                Community.class, cachedCommunities ->
                        cachedCommunities.stream().anyMatch(community -> Objects.equals(community.getId(), id))
        );

        communityRepository.deleteById(id);
    }

    @Override
    public Community getCommunityByTitle(String communityName) {
        return communityRepository.findByTitle(communityName);
    }

    @Override
    public String getCommunityTags(Long id) {
        Optional<String> optionalTags = communityRepository.findById(id).get().getTags().describeConstable();
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
