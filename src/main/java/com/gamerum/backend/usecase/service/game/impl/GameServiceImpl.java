package com.gamerum.backend.usecase.service.game.impl;

import com.gamerum.backend.external.client.api.game.GameDbApi;
import com.gamerum.backend.external.client.api.game.igdb.utils.endpoint.Endpoint;
import com.gamerum.backend.external.client.api.game.igdb.utils.query.QueryBuilder;
import com.gamerum.backend.external.client.api.game.igdb.utils.query.Sort;
import com.gamerum.backend.usecase.service.game.GameService;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proto.Game;
import proto.GameResult;
import proto.PopularityPrimitive;
import proto.PopularityPrimitiveResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDbApi api;

    @Override
    public List<String> getTopFivePopularGames() throws IOException, ExecutionException, InterruptedException {
        String popularityQuery = QueryBuilder
                .builder()
                .fields("game_id, value, popularity_type")
                .sort("value", Sort.DESC)
                .limit(5)
                .where("popularity_type = 1")
                .build();

        byte[] popularityResponse = api.makeProtoRequest(Endpoint.POPULARITY_PRIMITIVES.toString(), popularityQuery);
        List<PopularityPrimitive> popularityPrimitives =
                PopularityPrimitiveResult.parseFrom(popularityResponse).getPopularityprimitivesList();

        StringBuilder gameIds = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            gameIds.append(popularityPrimitives.get(i).getGameId());
            if (i != 4) gameIds.append(", ");
        }

        String gameQuery = QueryBuilder
                .builder()
                .fields("id, name")
                .where("id = (" + gameIds + ")")
                .build();

        byte[] gameResponse = api.makeProtoRequest(Endpoint.GAMES.toString(), gameQuery);
        List<Game> games = GameResult.parseFrom(gameResponse).getGamesList();

        List<String> gameNames = new ArrayList<>();

        for (Game game : games) {
            gameNames.add(game.getName());
        }
        return gameNames;
    }

    @Override
    public List<String> search(String name, Integer limit, Integer offset) throws ExecutionException, InterruptedException, InvalidProtocolBufferException {
        String query = QueryBuilder.builder()
                .fields("id, name, parent_game, alternative_names.name")
                .limit(limit)
                .offset(offset)
                .where("name ~ \"" + name + "\"* | " +
                        "alternative_names.name ~ \""  + name + "\"* & " +
                        "parent_game = null & " +
                        "version_parent = null;" )
                .sort("name", Sort.ASC)
                .build();

        byte[] gameResponse = api.makeProtoRequest(Endpoint.GAMES.toString(), query);
        List<Game> games = GameResult.parseFrom(gameResponse).getGamesList();

        List<String> gameNames = new ArrayList<>();

        for (Game game : games) {
            gameNames.add(game.getName());
        }
        return gameNames;
    }
}
