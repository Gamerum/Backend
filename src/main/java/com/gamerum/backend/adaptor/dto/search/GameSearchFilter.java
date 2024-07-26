package com.gamerum.backend.adaptor.dto.search;

import lombok.Getter;

import java.util.List;

@Getter
public class GameSearchFilter extends SearchFilter{
    private final List<Integer> genreIds;

    public GameSearchFilter(String keyword, Integer page, Integer size, List<Integer> genreIds) {
        super(keyword, page, size);
        this.genreIds = genreIds;
    }
}
