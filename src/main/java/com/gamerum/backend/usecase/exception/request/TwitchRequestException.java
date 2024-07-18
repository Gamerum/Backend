package com.gamerum.backend.usecase.exception.request;


public class TwitchRequestException extends RequestException {
    public TwitchRequestException(int status, String message) {
        super(status, "While server trying to access Twitch an exception occurred: " + message);
    }
}
