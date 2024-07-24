package com.gamerum.backend.adaptor.dto.response.auth;

import com.gamerum.backend.adaptor.dto.response.Response;
import lombok.Getter;

@Getter
public class RegisterResponse extends Response {

    public RegisterResponse(boolean success, String message) {
        super(success, message);
    }
}
