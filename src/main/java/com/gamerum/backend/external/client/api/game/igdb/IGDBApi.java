package com.gamerum.backend.external.client.api.game.igdb;

import com.gamerum.backend.external.client.api.game.GameDbApi;
import com.gamerum.backend.external.client.api.game.igdb.utils.token.IGDBTokenHandler;
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

    public HttpResponse<JsonNode> makeJsonRequest(String endpoint, String query) throws UnirestException {
        String requestUrl = baseUrl + endpoint;

        return Unirest.post(requestUrl)
                .header("client-id", clientId)
                .header("authorization", tokenHandler.getAuthorization())
                .header("x-user-agent", "igdb-api-jvm")
                .body(query)
                .asJson();
    }
}
