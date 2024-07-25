package com.gamerum.backend.adaptor.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SearchFilter {
    protected String keyword;
    protected Integer page;
    protected Integer size;
}
