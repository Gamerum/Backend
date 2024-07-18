package com.gamerum.backend.external.client.api.game;

import java.util.concurrent.ExecutionException;

public interface GameDbApi {
    byte[] makeProtoRequest(String endpoint, String query) throws ExecutionException, InterruptedException;
}
