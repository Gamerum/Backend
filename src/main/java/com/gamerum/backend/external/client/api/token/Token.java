package com.gamerum.backend.external.client.api.token;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class Token {
    private String tokenType;
    private String accessToken;
    private Instant expireTime;
}
