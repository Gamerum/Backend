package com.gamerum.backend.usecase.service.search;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;

import java.util.List;

public interface SearchService {
    List<GameDocument> searchGameWithName(String searchTerm, int page, int size);
    String searchGameWithGenres(String searchTerm, int page, int size);
    List<CommunityDocument> searchCommunity(String searchTerm, int page, int size);
    List<ProfileDocument> searchProfile(String searchTerm, int page, int size);
    List<PostDocument> searchPost(String searchTerm, int page, int size);
}
