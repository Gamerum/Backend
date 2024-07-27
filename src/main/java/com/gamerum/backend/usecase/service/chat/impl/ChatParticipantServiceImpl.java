package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantUpdateDTO;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
                new NotFoundException("Chat"));

        Profile profile = profileRepository.findById(chatParticipantCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new AlreadyParticipatedException(profile.getNickname());

        return chatParticipantRepository.save(
                new ChatParticipant(profile, chat, chatParticipantCreateDTO.getAddedByProfileId(), false));
    }

    @Override
    public void deleteByIdChatParticipant(Long chatId, Long chatParticipantId, Long deleterProfileId) {
        ChatParticipant deleter = chatParticipantRepository.findByChatIdAndProfileId(chatId, deleterProfileId)
                .orElseThrow(NotParticipatedException::new);
        if (!deleter.isAdmin()) throw new NotAllowedException();
        chatParticipantRepository.deleteById(chatParticipantId);
    }

    @Override
    public List<ChatParticipant> getChatParticipants(Long chatId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return chatParticipantRepository.findByChatId(chatId, pageable);
    }

    @Override
    public ChatParticipant updateChatParticipant(long chatId, ChatParticipantUpdateDTO chatParticipantUpdateDTO) {
        ChatParticipant updater = chatParticipantRepository.findByChatIdAndProfileId(chatId,
                chatParticipantUpdateDTO.getUpdaterProfileId()).orElseThrow(NotParticipatedException::new);

        if (!updater.isAdmin()) throw new NotAllowedException();

        ChatParticipant participant = chatParticipantRepository.findById(chatParticipantUpdateDTO.getId())
                .orElseThrow(NotParticipatedException::new);

        participant.setAdmin(chatParticipantUpdateDTO.isAdmin());
        participant.setUpdatedAt(LocalDateTime.now());
        participant.setUpdatedBy(chatParticipantUpdateDTO.getUpdaterProfileId());

        return chatParticipantRepository.save(participant);
    }

}
