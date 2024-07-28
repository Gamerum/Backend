package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.message.MessageCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.*;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.MessageRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ChatParticipantRepository chatParticipantRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Message createMessage(Long chatId, MessageCreateDTO messageCreateDTO, String token) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new NotFoundException("Chat"));

        Profile profile = profileRepository.findById(jwtUtil.getProfileIdFromToken(token))
                .orElseThrow(() -> new NotFoundException("Profile"));

        if (chatParticipantRepository.existsByChatIdAndProfileId(chatId, profile.getId()))
            throw new NotParticipatedException();

        return messageRepository.save(
                new Message(chat, profile, messageCreateDTO.getText(), messageCreateDTO.isSent()));
    }

    @Override
    public void deleteByIdMessage(Long chatId, Long messageId, String token) {
        Message message = messageRepository.findByIdAndChatId(messageId, chatId)
                .orElseThrow(() -> new NotFoundException("Message"));

        if (jwtUtil.hasRole(token, UserRole.ROLE_ADMIN)) {
            messageRepository.deleteById(messageId);
            return;
        }

        Long profileId = jwtUtil.getProfileIdFromToken(token);

        if (Objects.equals(message.getProfile().getId(), profileId)) {
            messageRepository.deleteById(messageId);
            return;
        }

        ChatParticipant chatParticipant = chatParticipantRepository.findByChatIdAndProfileId(chatId, profileId)
                .orElseThrow(NotParticipatedException::new);

        if (!chatParticipant.isAdmin())
            throw new NotAllowedException();

        messageRepository.deleteById(messageId);
    }

    @Override
    public List<Message> getAllMessages(Long chatId, int page, int size, String token) {
        Pageable pageable = PageRequest.of(page, size);

        if (jwtUtil.hasRole(token, UserRole.ROLE_ADMIN))
            return messageRepository.findByChatId(chatId, pageable);

        if (!chatParticipantRepository.existsByChatIdAndProfileId(chatId, jwtUtil.getProfileIdFromToken(token)))
            throw new NotParticipatedException();

        return messageRepository.findByChatId(chatId, pageable);
    }

    @Override
    public Message updateMessage(Long chatId, MessageUpdateDTO messageUpdateDTO, String token) {
        Long profileId = jwtUtil.getProfileIdFromToken(token);

        Message message = messageRepository.findByIdAndChatId(messageUpdateDTO.getId(), chatId)
                .orElseThrow(() -> new NotFoundException("Message"));

        message.setText(messageUpdateDTO.getMessage());
        message.setUpdatedAt(LocalDateTime.now());
        message.setUpdatedBy(profileId);

        if (!Objects.equals(message.getProfile().getId(), profileId))
            throw new NotAllowedException();

        return messageRepository.save(message);
    }
}
