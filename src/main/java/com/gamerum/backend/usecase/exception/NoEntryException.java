package com.gamerum.backend.usecase.exception;

import org.springframework.http.HttpStatus;

public class NoEntryException extends ErrorException {
    public NoEntryException(String entry) {
        super(ErrorCode.HAS_NO_ENTRY, HttpStatus.CONFLICT, entry + " not found!");
    }
}
