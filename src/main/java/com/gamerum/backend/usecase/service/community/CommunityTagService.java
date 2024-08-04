package com.gamerum.backend.usecase.service.community;

import com.gamerum.backend.external.persistence.relational.entity.Community;

import java.util.List;

public interface CommunityTagService {
    String addTags(Community community, List<String> tags);
    String removeTags(Community community, List<String> tags);
}
