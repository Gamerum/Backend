package com.gamerum.backend.adaptor.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterRequestDTO {
    private String username;
    private String nickname;
    private String email;
    private String password;
}
