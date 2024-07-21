package com.gamerum.backend.usecase.service.search.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamerum.backend.external.client.api.game.GameDbApi;
import com.gamerum.backend.external.client.api.game.igdb.utils.endpoint.Endpoint;
import com.gamerum.backend.external.client.api.game.igdb.utils.query.QueryBuilder;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.CommunityESRepository;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.gamerum.backend.usecase.service.search.SearchService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {
    private final GameDbApi api;
    private final CommunityESRepository communityESRepository;


    @Override
    public String searchGame(String name, int page, int size) throws UnirestException, IGDBRequestException {
        String query = QueryBuilder.builder()
                .fields("id, name")
                .limit(size)
                .offset(page * size)
                .where("name ~ \"" + name + "\"* " +
                        "| alternative_names.name ~ \"" + name + "\" " +
                        "& parent_game = null " +
                        "& version_parent = null;")
                .sort("name asc")
                .build();

        HttpResponse<JsonNode> response = api.makeJsonRequest(Endpoint.GAMES.toString(), query);

        if (response.getStatus() != 200) {
            throw new IGDBRequestException(
                    response.getStatus(),
                    response.getBody().getArray().getJSONObject(0).getString("title"));
        }

        return response.getBody().toString();
    }

    @Override
    public Page<CommunityDocument> searchCommunity(String gameId, int page, int size) {
        Pageable pageable = PageRequest.of(0, 5);
        return communityESRepository.findByGameId(gameId, pageable);
    }
}
