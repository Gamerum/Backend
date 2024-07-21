package com.gamerum.backend.usecase.service.game;



import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface GameService {
    String getTop5PopularGames() throws UnirestException;
    void syncGamesWithElasticsearch();
}
