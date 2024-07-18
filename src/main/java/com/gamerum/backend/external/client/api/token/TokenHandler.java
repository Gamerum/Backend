package com.gamerum.backend.external.client.api.token;

import com.gamerum.backend.usecase.exception.request.TwitchRequestException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.SneakyThrows;


import java.time.temporal.ChronoUnit;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public abstract class TokenHandler {
    private Token token;

    public abstract String getAuthorization();

    @SneakyThrows
    protected Token getToken() {
        if (token == null || isTokenExpired()) token = getNewToken();
        return token;
    }

    protected abstract Token getNewToken() throws UnirestException, TwitchRequestException;

    protected abstract HttpResponse<JsonNode> fetchNewTokenFromAPI() throws UnirestException;

    protected Instant calculateExpirationTime(long expiredInSeconds) {
        return Instant.now().plus(expiredInSeconds, ChronoUnit.SECONDS);
    }

    private boolean isTokenExpired() {
        return token.getExpireTime().isBefore(Instant.now());
    }
}
