package com.gamerum.backend.usecase.service.game;

import com.google.protobuf.InvalidProtocolBufferException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface GameService {
    List<String> getTopFivePopularGames() throws UnirestException, IOException, ExecutionException, InterruptedException;
    List<String> search(String gameName, Integer limit, Integer offset) throws ExecutionException, InterruptedException, InvalidProtocolBufferException;
}
