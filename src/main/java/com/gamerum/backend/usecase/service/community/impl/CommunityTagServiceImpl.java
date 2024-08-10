package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.repository.CommunityRepository;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.service.community.CommunityTagService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityTagServiceImpl implements CommunityTagService {
    private final CommunityRepository communityRepository;

    @Value("${community.tag.separator}")
    private String tagSeparator;

    public CommunityTagServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public String addTags(Community community, List<String> tags) {
        if (tags == null || tags.isEmpty()) return null;

        List<String> currentTags = getTags(community);
        List<String> loweredCurrentTags = currentTags.stream().map(String::toLowerCase).toList();
        List<String> addableTags = filterAddableTags(loweredCurrentTags, tags);

        if (addableTags.isEmpty()) return null;
        return community.getTags().isBlank() ?
                String.join(tagSeparator, addableTags) :
                community.getTags() + tagSeparator + String.join(tagSeparator, addableTags);
    }

    @Override
    public String removeTags(Community community, List<String> tags) {
        if (tags == null || tags.isEmpty()) return null;

        List<String> currentTags = getTags(community);
        List<String> loweredTags = tags.stream().map(String::toLowerCase).toList();
        currentTags.removeIf(tag -> loweredTags.contains(tag.toLowerCase()));

        return String.join(tagSeparator, currentTags);
    }

    @Override
    public Boolean hasTag(Community community, String tag) {
        return community.getTags().toLowerCase().contains(tag.toLowerCase());
    }

    @Override
    public Boolean hasTag(Long communityId, String tag) {
        Community community = communityRepository.findById(communityId).
                orElseThrow(() -> new NotFoundException(Community.class));
        return hasTag(community, tag);
    }

    public List<String> getTags(Community community) {
        return new ArrayList<>(Arrays.stream(community.getTags().split(tagSeparator)).toList());
    }

    private List<String> filterAddableTags(List<String> currentTags, List<String> newTags) {
        return newTags.stream().map(String::toLowerCase)
                .filter(tag -> !currentTags.contains(tag)).distinct().collect(Collectors.toList());
    }
}
