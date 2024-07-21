package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatParticipantServiceImpl implements ChatParticipantService {
    @Autowired
    private ChatParticipantRepository chatParticipantRepository;
    @Override
    public ChatParticipant createChatParticipant(ChatParticipant chatParticipant) {
        return chatParticipantRepository.save(chatParticipant);
    }

    @Override
    public void deleteByIdChatParticipant(Long id) {
        chatParticipantRepository.deleteById(id);
    }

    @Override
    public ChatParticipant getChatParticipantId(Long id) {
        Optional<ChatParticipant> chatParticipant = chatParticipantRepository.findById(id);
        if(chatParticipant.isEmpty())
            throw new RuntimeException();
        return chatParticipant.get();
    }

    @Override
    public List<ChatParticipant> getChatParticipants() {
        return (List<ChatParticipant>) chatParticipantRepository.findAll();
    }

}
