package com.gamerum.backend.usecase.exception;

public class NotParticipatedException extends RuntimeException {
    public NotParticipatedException() {
        super("Looks like you or the other profile aren't joined yet.");
    }
}