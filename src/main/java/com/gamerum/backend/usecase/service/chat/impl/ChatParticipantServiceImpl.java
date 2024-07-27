package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.usecase.exception.AlreadyParticipatedException;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
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
    public ChatParticipant createChatParticipant(long chatId, ChatParticipantCreateDTO chatParticipantCreateDTO) {

        Chat chat = chatRepository.findById(chatId).orElseThrow(() ->
                new NotFoundException(Chat.class, "ID", chatId));

        Profile profile = profileRepository.findById(chatParticipantCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException(Profile.class, "ID", chatParticipantCreateDTO.getProfileId()));

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new AlreadyParticipatedException(profile.getNickname());

        return chatParticipantRepository.save(
                new ChatParticipant(profile, chat, chatParticipantCreateDTO.getAddedByProfileId(), false));
    }

    @Override
    public void deleteByIdChatParticipant(Long chatId, Long chatParticipantId, Long deleterProfileId){
        ChatParticipant participant = chatParticipantRepository.findByChatIdAndProfileId(chatId, deleterProfileId)
                        .orElseThrow(NotParticipatedException::new);
        if (!participant.isAdmin()) throw new NotAllowedException();
        chatParticipantRepository.deleteById(chatParticipantId);
    }

    @Override
    public List<ChatParticipant> getChatParticipants() {
        return (List<ChatParticipant>) chatParticipantRepository.findAll();
    }

}
