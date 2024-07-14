package com.gamerum.backend.security.auth.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String nickname;
    private String email;
    private String password;
}
