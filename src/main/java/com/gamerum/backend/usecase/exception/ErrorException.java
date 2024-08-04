package com.gamerum.backend.usecase.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorException extends RuntimeException{
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    public ErrorException(ErrorCode errorCode, HttpStatus httpStatus, String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
