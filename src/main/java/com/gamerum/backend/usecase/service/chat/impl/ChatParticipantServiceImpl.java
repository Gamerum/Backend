package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.usecase.exception.ChatParticipantExistsException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatParticipantServiceImpl implements ChatParticipantService {
    @Autowired
    private ChatParticipantRepository chatParticipantRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ChatParticipant createChatParticipant(long chatId, ChatParticipantCreateDTO chatParticipantCreateDTO)
            throws ChatParticipantExistsException {

        Chat chat = chatRepository.findById(chatId).orElseThrow(() ->
                new NotFoundException(Chat.class, "ID", chatId));

        Profile profile = profileRepository.findById(chatParticipantCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException(Profile.class, "ID", chatParticipantCreateDTO.getProfileId()));

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new ChatParticipantExistsException(profile.getNickname());

        return chatParticipantRepository.save(
                new ChatParticipant(profile, chat, chatParticipantCreateDTO.getAddedByProfileId(), false));
    }

    @Override
    public void deleteByIdChatParticipant(Long chatParticipantId) {
        chatParticipantRepository.deleteById(chatParticipantId);
    }

    @Override
    public ChatParticipant getChatParticipantId(Long chatParticipantId) {
        Optional<ChatParticipant> chatParticipant = chatParticipantRepository.findById(chatParticipantId);
        if(chatParticipant.isEmpty())
            throw new RuntimeException();
        return chatParticipant.get();
    }

    @Override
    public List<ChatParticipant> getChatParticipants() {
        return (List<ChatParticipant>) chatParticipantRepository.findAll();
    }

}
