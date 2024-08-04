package com.gamerum.backend.usecase.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ErrorResponse {
    private final List<String> errorCodes;

    public ErrorResponse(String errorCode) {
        this.errorCodes = List.of(errorCode);
    }

    public ErrorResponse(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
