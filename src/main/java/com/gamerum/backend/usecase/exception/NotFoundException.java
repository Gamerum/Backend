package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.utils.MessageCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends ErrorException{
    public <T> NotFoundException(Class<T> tClass) {
        super(MessageCode.NOT_FOUND_EXCEPTION, HttpStatus.NOT_FOUND, tClass.getSimpleName() + " not found!");
    }
}
