package com.gamerum.backend.external.client.api.game;

import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public interface GameDbSynchronizer {
    void syncData() throws UnirestException, IGDBRequestException, IOException;
}
