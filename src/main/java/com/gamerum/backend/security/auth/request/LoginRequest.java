package com.gamerum.backend.security.auth.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
