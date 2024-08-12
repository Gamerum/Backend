package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.utils.MessageCode;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ErrorException{
    public UnauthorizedException() {
        super(MessageCode.UNAUTHORIZED_EXCEPTION, HttpStatus.UNAUTHORIZED, "Unauthorized");
    }
}
