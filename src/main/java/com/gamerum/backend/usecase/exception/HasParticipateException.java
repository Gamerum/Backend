package com.gamerum.backend.usecase.exception;

public class HasParticipateException extends RuntimeException {
    public HasParticipateException() {
        super("There are participates");
    }
}
