package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.external.persistence.entity.ChatParticipant;

import java.util.List;

public interface ChatParticipantService {
    ChatParticipant createChatParticipant(ChatParticipant chatParticipant);
    void deleteByIdChatParticipant(Long chatParticipantId);
    ChatParticipant getChatParticipantId(Long chatParticipantId);
    List<ChatParticipant> getChatParticipants();
}
