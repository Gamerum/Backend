package com.gamerum.backend.adaptor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ErrorResponse extends Response {
    private final String details;

    public ErrorResponse(String message, String details) {
        super(false, message);
        this.details = details;
    }
}
