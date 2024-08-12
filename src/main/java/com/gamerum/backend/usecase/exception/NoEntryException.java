package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.utils.MessageCode;
import org.springframework.http.HttpStatus;

public class NoEntryException extends ErrorException {
    public NoEntryException(String entry) {
        super(MessageCode.HAS_NO_ENTRY, HttpStatus.CONFLICT, entry + " not found!");
    }
}
