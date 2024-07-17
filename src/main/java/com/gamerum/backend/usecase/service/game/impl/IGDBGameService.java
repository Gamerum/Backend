package com.gamerum.backend.usecase.service.game.impl;

import com.gamerum.backend.external.client.api.igdb.IGDBApi;
import com.gamerum.backend.external.client.api.igdb.utils.endpoint.Endpoint;
import com.gamerum.backend.external.client.api.igdb.utils.query.QueryBuilder;
import com.gamerum.backend.usecase.service.game.GameService;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proto.Game;
import proto.GameResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IGDBGameService implements GameService {

    @Autowired
    private IGDBApi api;

    @Override
    public List<String> getTopFivePopularGames() throws UnirestException, IOException {
        String query = QueryBuilder
                .builder()
                .fields("*")
                .build();

        byte[] responseBody = api.protoRequest(Endpoint.GAMES, query);
        List<Game> games = GameResult.parseFrom(responseBody).getGamesList();
        List<String> gameNames = new ArrayList<>();

        for(Game game : games) {
            gameNames.add(game.getName());
        }
        return gameNames;
    }

    @Override
    public String getGamesWithPagination(int offset, int limit) {
        return "";
    }
}
