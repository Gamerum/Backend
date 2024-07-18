package com.gamerum.backend.external.client.api.game;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;


public interface GameDbApi {
    HttpResponse<JsonNode> makeJsonRequest(String endpoint, String query) throws UnirestException;
}
