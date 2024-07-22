package com.gamerum.backend.external.client.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Token {
    private final String tokenType;
    private final String accessToken;
    private final Instant expireTime;

    @JsonCreator
    public Token(@JsonProperty("token_type") String tokenType,
                 @JsonProperty("access_token") String accessToken,
                 @JsonProperty("expires_in") long expiresIn){
        this.tokenType = tokenType;
        this.accessToken = accessToken;
        this.expireTime = Instant.now().plus(expiresIn, ChronoUnit.SECONDS);
    }

    public boolean isExpired() {
        return expireTime.isBefore(Instant.now());
    }

    public String getAuthorization() {
        return tokenType + " " + accessToken;
    }
}
