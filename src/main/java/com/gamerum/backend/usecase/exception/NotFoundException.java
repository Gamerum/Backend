package com.gamerum.backend.usecase.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends ErrorException{
    public <T> NotFoundException(Class<T> tClass) {
        super(ErrorCode.NOT_FOUND_EXCEPTION, HttpStatus.NOT_FOUND, tClass.getSimpleName() + " not found!");
    }
}
