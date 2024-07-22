package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;

import java.util.List;

public interface ChatParticipantService {
    ChatParticipant createChatParticipant(ChatParticipant chatParticipant);
    void deleteByIdChatParticipant(Long id);
    ChatParticipant getChatParticipantId(Long id);
    List<ChatParticipant> getChatParticipants();
}
