package com.gamerum.backend.usecase.exception;

import org.springframework.http.HttpStatus;

public class ParticipationException extends ErrorException{
    public ParticipationException(boolean isParticipated) {
        super(ErrorCode.PARTICIPATED_EXCEPTION, HttpStatus.CONFLICT, isParticipated ? "Profile already participated!" : "Profile is not participated!");
    }
}
