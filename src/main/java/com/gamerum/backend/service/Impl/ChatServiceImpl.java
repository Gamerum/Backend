package com.gamerum.backend.service.Impl;

import com.gamerum.backend.entity.Chat;
import com.gamerum.backend.repository.ChatRepository;
import com.gamerum.backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat getByChatId(Long id) {
        Optional<Chat> chat = chatRepository.findById(id);
        if(chat.isEmpty())
            throw new RuntimeException();
        return chat.get();
    }

    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public void deleteChat(Long id) {
       chatRepository.deleteById(id);
    }

    @Override
    public List<Chat> getChats() {
        return (List<Chat>) chatRepository.findAll();
    }
}
