package com.gamerum.backend.usecase.service.search;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface SearchService {
    List<GameDocument> searchGameWithName(String searchTerm, int page, int size);
    String searchGameWithGenres(String searchTerm, int page, int size) throws UnirestException, IGDBRequestException;
    List<CommunityDocument> searchCommunity(String searchTerm, int page, int size);
    List<ProfileDocument> searchProfile(String searchTerm, int page, int size);
    List<PostDocument> searchPost(String searchTerm, int page, int size);
}
