package com.gamerum.backend.adaptor.dto.auth.request;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String username;
    private String nickname;
    private String email;
    private String password;
}
