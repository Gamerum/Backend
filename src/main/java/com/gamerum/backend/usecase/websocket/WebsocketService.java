package com.gamerum.backend.usecase.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebsocketService {
    private final SimpMessagingTemplate messagingTemplate;

    public WebsocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public <T> void sendNotification(String destination, T object) {
        messagingTemplate.convertAndSend(destination, object);
    }
}
