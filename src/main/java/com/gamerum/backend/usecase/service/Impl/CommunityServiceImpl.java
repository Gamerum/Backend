package com.gamerum.backend.usecase.service.Impl;

import com.gamerum.backend.external.persistence.entity.Community;
import com.gamerum.backend.external.persistence.repository.CommunityRepository;
import com.gamerum.backend.usecase.service.CommunityService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private CommunityRepository communityRepository;

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
}
