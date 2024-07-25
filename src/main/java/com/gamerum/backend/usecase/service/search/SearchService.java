package com.gamerum.backend.usecase.service.search;

import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SearchService {
    Page<GameDocument> searchGame(GameSearchFilter filter);
    Iterable<GameDocument> getAllGames();
//    Page<CommunityDocument> searchCommunity(SearchFilter filter);
//    Page<ProfileDocument> searchProfile(SearchFilter filter);
//    Page<PostDocument> searchPost(SearchFilter filter);
}
