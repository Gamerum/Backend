package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.AlreadyParticipatedException;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChatParticipantServiceImpl implements ChatParticipantService {
    @Autowired
    private ChatParticipantRepository chatParticipantRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ChatParticipant createChatParticipant(long chatId, ChatParticipantCreateDTO chatParticipantCreateDTO) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() ->
                new NotFoundException("Chat"));

        if (!chatParticipantRepository.existsByChatIdAndProfileId(chatId, jwtUtil.getCurrentUserProfileId()))
            throw new NotAllowedException();

        Profile profile = profileRepository.findById(chatParticipantCreateDTO.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new AlreadyParticipatedException(profile.getNickname());



        return chatParticipantRepository.save(ChatParticipant.builder()
                .profile(profile)
                .chat(chat)
                .isAdmin(false)
                .build());
    }

    @Override
    public void deleteByIdChatParticipant(Long chatId, Long chatParticipantId) {
        if (jwtUtil.currentUserHasRole(UserRole.ROLE_ADMIN)) {
            chatParticipantRepository.deleteById(chatParticipantId);
            return;
        }

        Long deleterProfileId = jwtUtil.getCurrentUserProfileId();

        ChatParticipant deleter = chatParticipantRepository.findByChatIdAndProfileId(chatId, deleterProfileId)
                .orElseThrow(NotParticipatedException::new);

        if (Objects.equals(deleter.getProfile().getId(), deleterProfileId)) {
            chatParticipantRepository.deleteById(chatParticipantId);
            return;
        }

        if (!deleter.isAdmin()) throw new NotAllowedException();

        chatParticipantRepository.deleteById(chatParticipantId);

        if (chatParticipantRepository.countByChatId(chatId) == 0)
            chatRepository.deleteById(chatId);
    }

    @Override
    public List<ChatParticipant> getChatParticipants(Long chatId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (jwtUtil.currentUserHasRole(UserRole.ROLE_ADMIN))
            return chatParticipantRepository.findByChatId(chatId, pageable);

        if (!chatParticipantRepository.existsByChatIdAndProfileId(chatId, jwtUtil.getCurrentUserProfileId()))
            throw new NotParticipatedException();

        return chatParticipantRepository.findByChatId(chatId, pageable);
    }

    @Override
    public ChatParticipant updateChatParticipant(long chatId, ChatParticipantUpdateDTO chatParticipantUpdateDTO) {
        Long profileId = jwtUtil.getCurrentUserProfileId();

        ChatParticipant updater = chatParticipantRepository
                .findByChatIdAndProfileId(chatId, profileId)
                .orElseThrow(NotParticipatedException::new);

        if (!updater.isAdmin()) throw new NotAllowedException();

        ChatParticipant participant = chatParticipantRepository.findById(chatParticipantUpdateDTO.getId())
                .orElseThrow(NotParticipatedException::new);

        participant.setAdmin(chatParticipantUpdateDTO.isAdmin());

        return chatParticipantRepository.save(participant);
    }

}
