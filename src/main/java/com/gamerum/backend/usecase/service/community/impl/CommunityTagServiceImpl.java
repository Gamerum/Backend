package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.usecase.service.community.CommunityTagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityTagServiceImpl implements CommunityTagService {
    @Override
    public String addTags(Community community, List<String> tags) {
        if (tags == null || tags.isEmpty()) return null;

        List<String> currentTags = getCurrentTags(community);
        List<String> loweredCurrentTags = currentTags.stream().map(String::toLowerCase).toList();
        List<String> addableTags = filterAddableTags(loweredCurrentTags, tags);

        if (addableTags.isEmpty()) return null;
        return community.getTags() + "," + String.join(",", addableTags);
    }

    @Override
    public String removeTags(Community community, List<String> tags) {
        if (tags == null || tags.isEmpty()) return null;

        List<String> currentTags = getCurrentTags(community);
        List<String> loweredTags = tags.stream().map(String::toLowerCase).toList();
        currentTags.removeIf(tag -> !tag.equalsIgnoreCase("Popular") && loweredTags.contains(tag.toLowerCase()));

        return String.join(",", currentTags);
    }

    private List<String> filterAddableTags(List<String> currentTags, List<String> newTags) {
        return newTags.stream().map(String::toLowerCase)
                .filter(tag -> !currentTags.contains(tag)).distinct().collect(Collectors.toList());
    }

    private List<String> getCurrentTags(Community community) {
        return new ArrayList<>(Arrays.stream(community.getTags().split(",")).toList());
    }
}
