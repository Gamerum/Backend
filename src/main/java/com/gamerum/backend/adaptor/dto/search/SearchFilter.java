package com.gamerum.backend.adaptor.dto.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchFilter {
    protected String keyword;
    protected Integer page;
    protected Integer size;
}
