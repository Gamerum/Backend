package com.gamerum.backend.adaptor.dto.search;

import lombok.Getter;

@Getter
public class CommunitySearchFilter extends SearchFilter {
    private final String gameId;

    public CommunitySearchFilter(String keyword, Integer page, Integer size, String gameId) {
        super(keyword, page, size);
        this.gameId = gameId;
    }
}
