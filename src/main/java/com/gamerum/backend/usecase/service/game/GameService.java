package com.gamerum.backend.usecase.service.game;



import com.mashape.unirest.http.exceptions.UnirestException;

public interface GameService {
    String getTop5PopularGames() throws UnirestException;

    String search(String gameName, Integer limit, Integer offset) throws UnirestException, IGDBRequestException;
}
