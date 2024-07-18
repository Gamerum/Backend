package com.gamerum.backend.usecase.exception.request;

public class IGDBRequestException extends RequestException{
    public IGDBRequestException(int status, String message) {
        super(status, "While server trying to access IGDB an exception occurred: " + message);
    }
}
