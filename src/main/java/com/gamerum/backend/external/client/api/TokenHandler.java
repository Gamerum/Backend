package com.gamerum.backend.external.client.api;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;

import java.time.Instant;

public abstract class TokenHandler {
    private Token token;

    @SneakyThrows
    protected TokenHandler() {
        CompletableFuture<Token> futureToken = CompletableFuture.supplyAsync(this::getNewTokenAsync);
        token = futureToken.get();
    }

    @SneakyThrows
    public Token getToken(){
        if (token == null || isTokenExpired()) {
            CompletableFuture<Token> futureToken = CompletableFuture.supplyAsync(this::getNewTokenAsync);
            token = futureToken.get();
        }
        return token;
    }

    protected abstract Token getNewTokenAsync() throws URISyntaxException, IOException, InterruptedException;

    protected abstract HttpResponse<String> fetchNewTokenFromAPI() throws URISyntaxException, IOException, InterruptedException;

    protected Instant calculateExpirationTime(long expiredInSeconds) {
        return Instant.now().plus(expiredInSeconds, ChronoUnit.SECONDS);
    }

    private boolean isTokenExpired() {
        return token.getExpireTime().isBefore(Instant.now());
    }
}
