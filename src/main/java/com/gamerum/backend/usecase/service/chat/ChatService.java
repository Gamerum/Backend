package com.gamerum.backend.usecase.service.chat;

import com.gamerum.backend.external.persistence.entity.Chat;

import java.util.List;

public interface ChatService {

    Chat getByChatId(Long chatId);
    Chat createChat(Chat chat);
    void deleteChat(Long chatId);
    List<Chat> getChats();
}
