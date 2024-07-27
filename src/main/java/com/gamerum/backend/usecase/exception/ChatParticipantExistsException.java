package com.gamerum.backend.usecase.exception;

public class ChatParticipantExistsException extends Exception {
    public ChatParticipantExistsException(String nickname) {
        super(nickname + " is already participant of the chat");
    }
}
