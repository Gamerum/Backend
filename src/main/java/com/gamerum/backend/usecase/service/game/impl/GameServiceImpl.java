package com.gamerum.backend.usecase.service.game.impl;

import com.gamerum.backend.external.client.api.game.GameDbApi;
import com.gamerum.backend.external.client.api.game.igdb.utils.endpoint.Endpoint;
import com.gamerum.backend.external.client.api.game.igdb.utils.query.QueryBuilder;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.gamerum.backend.usecase.service.game.GameService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "${cache.config.data.game.cache_name}")
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDbApi api;

    @Override
    @Cacheable(key = "'popularGames'", unless = "#result == null || #result.isBlank()")
    public String getTop5PopularGames() throws UnirestException {
        String query = QueryBuilder.builder()
                .fields("id, name")
                .limit(5)
                .offset(0)
                .sort("total_rating desc")
                .build();

        HttpResponse<JsonNode> response = api.makeJsonRequest(Endpoint.GAMES.toString(), query);
        return response.getBody().toString();
    }

    @Override
    public String search(String name, Integer limit, Integer offset) throws UnirestException, IGDBRequestException {
        String query = QueryBuilder.builder()
                .fields("id, name")
                .limit(limit)
                .offset(offset)
                .where("name ~ \"" + name + "\"* " +
                        "| alternative_names.name ~ \"" + name + "\" " +
                        " parent_game = null " +
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
}
