package com.gamerum.backend.usecase.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ForbiddenException extends ErrorException{
    public <T> ForbiddenException() {
        super(ErrorCode.FORBIDDEN_EXCEPTION, HttpStatus.FORBIDDEN, "Forbidden");
    }
}
