package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.utils.MessageCode;
import org.springframework.http.HttpStatus;

public class BadRequestException extends ErrorException {
    public BadRequestException(String reason, String message) {
        super(MessageCode.BAD_REQUEST + ":" + reason, HttpStatus.BAD_REQUEST, message);
    }
}
