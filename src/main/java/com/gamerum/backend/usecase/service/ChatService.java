package com.gamerum.backend.usecase.service;

import com.gamerum.backend.external.persistence.entity.Chat;

import java.util.List;

public interface ChatService {

    Chat getByChatId(Long id);
    Chat createChat(Chat chat);
    void deleteChat(Long id);
    List<Chat> getChats();
}
