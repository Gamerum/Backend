package com.gamerum.backend.usecase.service.community.impl;

import com.gamerum.backend.external.persistence.relational.entity.community.Community;
import com.gamerum.backend.usecase.exception.BadRequestException;
import com.gamerum.backend.usecase.service.community.CommunityRuleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommunityRuleServiceImpl implements CommunityRuleService {

    @Value("${community.separator}")
    private String separator;
    @Value("${community.rule.size}")
    private int maxRuleSize;

    @Override
    public String addRules(Community community, List<String> newRules) {
        if (newRules == null || newRules.isEmpty()) return null;

        List<String> currentRules = getRules(community);

        if (currentRules.size() + newRules.size() > maxRuleSize)
            throw new BadRequestException("community-rule-size", "Exceeds community rule size");

        return community.getRules().isBlank() ?
                String.join(separator, newRules) :
                community.getRules() + separator + String.join(separator, newRules);
    }

    @Override
    public String removeRules(Community community, List<String> rules) {
        if (rules == null || rules.isEmpty()) return null;

        List<String> currentRules = getRules(community).reversed();
        List<String> loweredCurrentRules = currentRules.stream().map(String::toLowerCase).toList();
        rules.forEach(rule -> currentRules.remove(loweredCurrentRules.indexOf(rule.toLowerCase())));

        return String.join(separator, currentRules.reversed());
    }

    @Override
    public List<String> getRules(Community community) {
        return new ArrayList<>(Arrays.stream(community.getRules().split(separator)).toList());
    }
}
