package com.gamerum.backend.usecase.exception;

import com.gamerum.backend.usecase.utils.MessageCode;
import org.springframework.http.HttpStatus;

public class ParticipationException extends ErrorException{
    public ParticipationException(boolean isParticipated) {
        super(isParticipated ? MessageCode.ALREADY_PARTICIPATED_EXCEPTION : MessageCode.NOT_PARTICIPATED_EXCEPTION,
                isParticipated ? HttpStatus.CONFLICT : HttpStatus.FORBIDDEN,
                isParticipated ? "Profile already participated!" : "Profile is not participated!");
    }
}
