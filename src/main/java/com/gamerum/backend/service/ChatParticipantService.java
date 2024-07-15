package com.gamerum.backend.service;

import com.gamerum.backend.entity.ChatParticipant;

import java.util.List;

public interface ChatParticipantService {
    ChatParticipant createChatParticipant(ChatParticipant chatParticipant);
    void deleteByIdChatParticipant(Long id);
    ChatParticipant getChatParticipantId(Long id);
    List<ChatParticipant> getChatParticipants();
}
