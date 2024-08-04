package com.gamerum.backend.adaptor.dto.search;

import lombok.Getter;

@Getter
public class PostSearchFilter extends SearchFilter {
    private final String communityId;
    private final String tag;
    public PostSearchFilter(String keyword, Integer page, Integer size, String communityId, String tag) {
        super(keyword, page, size);
        this.communityId = communityId;
        this.tag = tag;
    }
}
