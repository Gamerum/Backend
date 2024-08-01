package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.AlreadyParticipatedException;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatParticipantServiceImpl implements ChatParticipantService {
    private final ChatParticipantRepository chatParticipantRepository;
    private final ChatRepository chatRepository;
    private final ProfileRepository profileRepository;
    private final CurrentUser currentUser;

    public ChatParticipantServiceImpl(ChatParticipantRepository chatParticipantRepository,
                                      ChatRepository chatRepository,
                                      ProfileRepository profileRepository,
                                      CurrentUser currentUser) {
        this.chatParticipantRepository = chatParticipantRepository;
        this.chatRepository = chatRepository;
        this.profileRepository = profileRepository;
        this.currentUser = currentUser;
    }

    @Override
    public ChatParticipant createChatParticipant(Long chatId, ChatParticipantCreateDTO chatParticipantCreateDTO) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new NotFoundException("Chat"));

        Profile profile = profileRepository.findById(chatParticipantCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (!chatParticipantRepository.existsByChatIdAndProfileId(chatId, currentUser.getProfileId()))
            throw new NotAllowedException();

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new AlreadyParticipatedException(profile.getNickname());

        return chatParticipantRepository.save(ChatParticipant.builder()
                .profile(profile)
                .chat(chat)
                .isMod(false)
                .build());
    }

    @Override
    @Transactional
    public void deleteByIdChatParticipant(Long chatId, Long chatParticipantId) {
        if (!currentUser.hasRole(UserRole.ROLE_ADMIN)) {
            Long deleterProfileId = currentUser.getProfileId();

            ChatParticipant deleter = chatParticipantRepository
                    .findByChatIdAndProfileId(chatId, deleterProfileId)
                    .orElseThrow(NotParticipatedException::new);

            if (!deleter.isMod() && !deleter.getProfile().getId().equals(deleterProfileId))
                throw new NotAllowedException();
        }
        chatParticipantRepository.deleteById(chatParticipantId);
        if (chatParticipantRepository.countByChatId(chatId) == 0)
            chatRepository.deleteById(chatId);
    }

    @Override
    public List<ChatParticipant> getChatParticipants(Long chatId, int page, int size) {
        if (!currentUser.hasRole(UserRole.ROLE_ADMIN) &&
                !chatParticipantRepository.existsByChatIdAndProfileId(chatId, currentUser.getProfileId()))
            throw new NotParticipatedException();
        return chatParticipantRepository.findByChatId(chatId, PageRequest.of(page, size));
    }

    @Override
    public ChatParticipant updateChatParticipant(Long chatId, ChatParticipantUpdateDTO chatParticipantUpdateDTO) {
        ChatParticipant updater = chatParticipantRepository
                .findByChatIdAndProfileId(chatId, currentUser.getProfileId())
                .orElseThrow(NotParticipatedException::new);

        if (!updater.isMod()) throw new NotAllowedException();

        ChatParticipant participant = chatParticipantRepository
                .findById(chatParticipantUpdateDTO.getId())
                .orElseThrow(NotParticipatedException::new);

        participant.setMod(chatParticipantUpdateDTO.isMod());
        return chatParticipantRepository.save(participant);
    }

}
