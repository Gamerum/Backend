package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.gamerum.backend.usecase.service.game.GameService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/api/public/game/top_five_popular_games")
    public ResponseEntity<String> getTopFivePopularGames() throws UnirestException {
        return new ResponseEntity<>(gameService.getTop5PopularGames(), HttpStatus.OK);
    }

    @GetMapping("/api/public/search/game")
    public ResponseEntity<String> searchGame(@RequestParam String name,
                                             @RequestParam Integer limit,
                                             @RequestParam Integer offset)
            throws UnirestException, IGDBRequestException {
        return new ResponseEntity<>(gameService.search(name, limit, offset), HttpStatus.OK);
    }
}
