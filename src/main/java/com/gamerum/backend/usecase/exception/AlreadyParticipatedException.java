package com.gamerum.backend.usecase.exception;

public class AlreadyParticipatedException extends RuntimeException {
    public AlreadyParticipatedException(String nickname) {
        super(nickname + " is already joined");
    }
}
