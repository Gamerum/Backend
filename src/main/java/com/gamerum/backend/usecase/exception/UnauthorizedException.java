package com.gamerum.backend.usecase.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ErrorException{
    public UnauthorizedException() {
        super(ErrorCode.UNAUTHORIZED_EXCEPTION, HttpStatus.UNAUTHORIZED, "Unauthorized");
    }
}
