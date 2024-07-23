package com.gamerum.backend.adaptor.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDTO {
    private String username;
    private String password;
}
