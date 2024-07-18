package com.gamerum.backend.usecase.service.game;


import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface GameService {
    List<String> getTopFivePopularGames();

    String search(String gameName, Integer limit, Integer offset) throws UnirestException, IGDBRequestException;
}
