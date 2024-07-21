package com.gamerum.backend.usecase.service.search;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.data.domain.Page;

public interface SearchService {
    String searchGame(String name, int page, int size) throws UnirestException, IGDBRequestException;
    Page<CommunityDocument> searchCommunity(String gameId, int page, int size);
}
