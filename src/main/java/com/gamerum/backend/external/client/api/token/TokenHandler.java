package com.gamerum.backend.external.client.api.token;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;

import java.time.Instant;

public abstract class TokenHandler {
    private Token token;

    public abstract String getAuthorization();

    @SneakyThrows
    protected TokenHandler() {
        CompletableFuture<Token> futureToken = CompletableFuture.supplyAsync(this::getNewTokenAsync);
        token = futureToken.get();
    }

    @SneakyThrows
    protected Token getToken(){
        if (token == null || isTokenExpired()) {
            CompletableFuture<Token> futureToken = CompletableFuture.supplyAsync(this::getNewTokenAsync);
            token = futureToken.get();
        }
        return token;
    }

    protected abstract Token getNewTokenAsync() throws URISyntaxException, IOException, InterruptedException, UnirestException;

    protected abstract HttpResponse<JsonNode> fetchNewTokenFromAPI() throws URISyntaxException, IOException, InterruptedException, UnirestException;

    protected Instant calculateExpirationTime(long expiredInSeconds) {
        return Instant.now().plus(expiredInSeconds, ChronoUnit.SECONDS);
    }

    private boolean isTokenExpired() {
        return token.getExpireTime().isBefore(Instant.now());
    }
}
