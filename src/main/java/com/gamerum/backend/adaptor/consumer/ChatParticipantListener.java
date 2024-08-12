package com.gamerum.backend.adaptor.consumer;

import com.gamerum.backend.adaptor.mapper.chat.MessageMapper;
import com.gamerum.backend.external.persistence.relational.entity.chat.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.chat.Message;
import com.gamerum.backend.external.persistence.relational.repository.MessageRepository;
import com.gamerum.backend.usecase.websocket.WebsocketService;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import org.springframework.context.annotation.Lazy;

import static com.gamerum.backend.usecase.utils.MessageCode.CHAT_PARTICIPANT_ADDED;
import static com.gamerum.backend.usecase.utils.MessageCode.CHAT_PARTICIPANT_REMOVED;

public class ChatParticipantListener {
    private final WebsocketService websocketService;
    private final MessageRepository messageRepository;

    public ChatParticipantListener(WebsocketService websocketService, @Lazy MessageRepository messageRepository) {
        this.websocketService = websocketService;
        this.messageRepository = messageRepository;
    }

    @PostPersist
    public void postPersist(ChatParticipant chatParticipant) {
        String destination = "/topic/chat/" + chatParticipant.getChat().getId();

        Message message = Message.builder()
                .type(Message.Type.SYSTEM)
                .text(CHAT_PARTICIPANT_ADDED + ":" + chatParticipant.getProfile().getNickname())
                .chat(chatParticipant.getChat())
                .profile(chatParticipant.getProfile())
                .build();

        websocketService.sendNotification(destination, MessageMapper.INSTANCE.messageToMessageGetDTO(message));
        message.setSent(true);
        messageRepository.save(message);
    }

    @PostRemove
    public void postRemove(ChatParticipant chatParticipant) {
        String destination = "/topic/chat/" + chatParticipant.getChat().getId();

        Message message = Message.builder()
                .type(Message.Type.SYSTEM)
                .text(CHAT_PARTICIPANT_REMOVED + ":" + chatParticipant.getProfile().getNickname())
                .chat(chatParticipant.getChat())
                .profile(chatParticipant.getProfile())
                .build();

        websocketService.sendNotification(destination, MessageMapper.INSTANCE.messageToMessageGetDTO(message));
        message.setSent(true);
        messageRepository.save(message);
    }
}
