package com.gamerum.backend.service;

import com.gamerum.backend.entity.Chat;

import java.util.List;

public interface ChatService {

    Chat getByChatId(Long id);
    Chat createChat(Chat chat);
    void deleteChat(Long id);
    List<Chat> getChats();
}
