package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.usecase.service.game.GameService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/api/public/game/top_five_popular_games")
    public ResponseEntity<List<String>> getTopFivePopularGames()
            throws UnirestException, IOException, ExecutionException, InterruptedException {
        return new ResponseEntity<>(gameService.getTopFivePopularGames(), HttpStatus.OK);
    }

    @GetMapping("/api/public/search/game")
    public ResponseEntity<List<String>> searchGame(@RequestParam String name,
                                                   @RequestParam Integer limit,
                                                   @RequestParam Integer offset)
            throws IOException, ExecutionException, InterruptedException {
        return new ResponseEntity<>(gameService.search(name, limit, offset), HttpStatus.OK);
    }
}
