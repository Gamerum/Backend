package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.utils.MessageCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ForbiddenException extends ErrorException{
    public <T> ForbiddenException() {
        super(MessageCode.FORBIDDEN_EXCEPTION, HttpStatus.FORBIDDEN, "Forbidden");
    }
}
