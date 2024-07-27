package com.gamerum.backend.usecase.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException() {
        super("You are not allowed to do that");
    }
}
