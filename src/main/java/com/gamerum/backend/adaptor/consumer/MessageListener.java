package com.gamerum.backend.adaptor.consumer;

import com.gamerum.backend.adaptor.mapper.chat.MessageMapper;
import com.gamerum.backend.external.persistence.relational.entity.chat.Message;
import com.gamerum.backend.external.persistence.relational.repository.MessageRepository;
import com.gamerum.backend.usecase.websocket.WebsocketService;
import jakarta.persistence.PostPersist;
import org.springframework.context.annotation.Lazy;

public class MessageListener {
    private final WebsocketService websocketService;
    private final MessageRepository messageRepository;

    public MessageListener(WebsocketService websocketService, @Lazy MessageRepository messageRepository) {
        this.websocketService = websocketService;
        this.messageRepository = messageRepository;
    }

    @PostPersist
    public void postPersist(Message message) {
        String destination = "/topic/chat/" + message.getChat().getId();
        websocketService.sendNotification(destination, MessageMapper.INSTANCE.messageToMessageGetDTO(message));
        message.setSent(true);
        messageRepository.save(message);
    }
}
