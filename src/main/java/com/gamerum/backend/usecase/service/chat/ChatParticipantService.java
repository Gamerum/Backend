package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.usecase.exception.ChatParticipantExistsException;

import java.util.List;

public interface ChatParticipantService {
    ChatParticipant createChatParticipant(long chatId, ChatParticipantCreateDTO chatParticipantCreateDTO) throws ChatParticipantExistsException;
    void deleteByIdChatParticipant(Long chatParticipantId);
    ChatParticipant getChatParticipantId(Long chatParticipantId);
    List<ChatParticipant> getChatParticipants();
}
