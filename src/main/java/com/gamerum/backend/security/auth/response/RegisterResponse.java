package com.gamerum.backend.security.auth.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private boolean success;
    private String message;
}
