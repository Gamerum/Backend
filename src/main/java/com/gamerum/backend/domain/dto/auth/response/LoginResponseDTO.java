package com.gamerum.backend.domain.dto.auth.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDTO {
    private boolean success;
    private String message;
    private String tokenType;
    private String token;
}
