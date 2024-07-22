package com.gamerum.backend.external.client.api.game.igdb;

import com.gamerum.backend.external.client.api.game.GameDbApi;
import com.gamerum.backend.external.client.api.game.igdb.utils.endpoint.Endpoint;
import com.gamerum.backend.external.client.api.game.igdb.utils.query.QueryBuilder;
import com.gamerum.backend.external.client.api.game.igdb.utils.token.IGDBTokenHandler;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IGDBApi implements GameDbApi {
    private final String baseUrl = "https://api.igdb.com/v4/";

    @Value("${api.twitch.client_id}")
    private String clientId;

    @Autowired
    private IGDBTokenHandler tokenHandler;

    @Override
    public HttpResponse<JsonNode> makeJsonRequest(String endpoint, String query) throws UnirestException {
        String requestUrl = baseUrl + endpoint;

        return Unirest.post(requestUrl)
                .header("client-id", clientId)
                .header("authorization", tokenHandler.getAuthorization())
                .header("x-user-agent", "igdb-api-jvm")
                .body(query)
                .asJson();
    }

    @Override
    public JsonNode getGames(int page, int size) throws UnirestException, IGDBRequestException {
        String query = QueryBuilder.builder()
                .fields("id, name, genres.name")
                .limit(size)
                .offset(page * size)
                .where("parent_game = null " +
                        "& version_parent = null;")
                .build();

        HttpResponse<JsonNode> response = makeJsonRequest(Endpoint.GAMES.toString(), query);

        if (response.getStatus() != 200) {
            throw new IGDBRequestException(
                    response.getStatus(),
                    response.getBody().getArray().getJSONObject(0).getString("title"));
        }

        return response.getBody();
    }
}
