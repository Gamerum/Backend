package com.gamerum.backend.service;

import com.gamerum.backend.entity.Chat;
import com.gamerum.backend.entity.ChatParticipant;
import com.gamerum.backend.entity.Message;

import java.util.List;
import java.util.Optional;

public interface ChatService {

    Chat getByChatId(Long id);
    Chat createChat(Chat chat);
    void deleteChat(Long id);
    List<Chat> getChats();

    ChatParticipant createChatParticipant(ChatParticipant chatParticipant);
    void deleteByIdChatParticipant(Long id);
    ChatParticipant getChatParticipantId(Long id);
    List<ChatParticipant> getChatParticipants();

    Message createMessage(Message message);
    void deleteByIdMessage(Long id);
    List<Message> getAllMessages(Long id);
}
