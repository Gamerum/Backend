package com.gamerum.backend.usecase.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException() {
        super("Sorry, you can't do that.");
    }
}
