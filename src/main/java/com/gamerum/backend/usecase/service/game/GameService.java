package com.gamerum.backend.usecase.service.game;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import proto.Game;

import java.io.IOException;
import java.util.List;

public interface GameService {
    List<String> getTopFivePopularGames() throws UnirestException, IOException;
    String getGamesWithPagination(int offset, int limit);
}
