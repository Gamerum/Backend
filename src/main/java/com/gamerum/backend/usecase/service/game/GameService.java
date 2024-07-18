package com.gamerum.backend.usecase.service.game;


import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface GameService {
    List<String> getTopFivePopularGames();

    String search(String gameName, Integer limit, Integer offset) throws UnirestException;
}
