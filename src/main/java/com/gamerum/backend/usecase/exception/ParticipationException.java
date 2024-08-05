package com.gamerum.backend.usecase.exception;

import org.springframework.http.HttpStatus;

public class ParticipationException extends ErrorException{
    public ParticipationException(boolean isParticipated) {
        super(isParticipated ? ErrorCode.ALREADY_PARTICIPATED_EXCEPTION : ErrorCode.NOT_PARTICIPATED_EXCEPTION,
                isParticipated ? HttpStatus.CONFLICT : HttpStatus.FORBIDDEN,
                isParticipated ? "Profile already participated!" : "Profile is not participated!");
    }
}
