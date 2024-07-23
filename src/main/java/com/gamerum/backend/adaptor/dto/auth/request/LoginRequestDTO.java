package com.gamerum.backend.adaptor.dto.auth.request;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;
}
