package com.gamerum.backend.adaptor.dto.search;

import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import lombok.Getter;

import java.util.List;

@Getter
public class GameSearchFilter extends SearchFilter{
    private final List<GameDocument.Genre> genres;

    public GameSearchFilter(String keyword, Integer page, Integer size, List<GameDocument.Genre> genres) {
        super(keyword, page, size);
        this.genres = genres;
    }
}
