package com.gamerum.backend.adaptor.dto.response.auth;

import com.gamerum.backend.adaptor.dto.response.Response;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class LoginResponse extends Response {
    private final String tokenType;
    private final String token;

    public LoginResponse(boolean success, String message, String tokenType, String token) {
        super(success, message);
        this.tokenType = tokenType;
        this.token = token;
    }
}
