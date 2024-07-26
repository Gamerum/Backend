package com.gamerum.backend.usecase.service.search;

import com.gamerum.backend.adaptor.dto.search.CommunitySearchFilter;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.adaptor.dto.search.SearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;

public interface SearchService {
    List<GameDocument> searchGame(GameSearchFilter filter) throws IOException;
    List<CommunityDocument> searchCommunity(CommunitySearchFilter filter) throws IOException;
    List<ProfileDocument> searchProfile(SearchFilter filter) throws IOException;
//    Page<PostDocument> searchPost(SearchFilter filter);
}
