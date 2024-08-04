package com.gamerum.backend.usecase.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UnauthorizedException extends ErrorException{
    public <T> UnauthorizedException() {
        super(ErrorCode.UNAUTHORIZED_EXCEPTION, HttpStatus.UNAUTHORIZED, "Unauthorized");
    }
}
