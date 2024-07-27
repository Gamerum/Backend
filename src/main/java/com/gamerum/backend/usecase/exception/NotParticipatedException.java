package com.gamerum.backend.usecase.exception;

public class NotParticipatedException extends RuntimeException {
    public NotParticipatedException() {
        super("You are not joined");
    }
}