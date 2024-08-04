package com.gamerum.backend.usecase.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final ErrorCode errorCode;

    public ErrorResponse(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
