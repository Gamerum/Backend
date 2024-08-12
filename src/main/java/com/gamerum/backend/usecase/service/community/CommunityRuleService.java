package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.external.persistence.relational.entity.community.Community;

import java.util.List;

public interface CommunityRuleService {
    String addRules(Community community, List<String> rules);
    String removeRules(Community community, List<String> rules);
    List<String> getRules(Community community);
}
