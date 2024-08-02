package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Message;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.MessageRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.ChatService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ChatServiceImpl implements ChatService {
    @Value("${page.chat.init_participant_size}")
    private int initParticipantSize;

    @Value("${page.chat.init_message_size}")
    private int initMessagesSize;

    @Value("${page.chat.size}")
    private int chatPageSize;

    private final ChatRepository chatRepository;
    private final ProfileRepository profileRepository;
    private final ChatParticipantRepository chatParticipantRepository;
    private final MessageRepository messageRepository;
    private final CurrentUser currentUser;

    public ChatServiceImpl(ChatRepository chatRepository, ProfileRepository profileRepository, ChatParticipantRepository chatParticipantRepository, MessageRepository messageRepository, CurrentUser currentUser) {
        this.chatRepository = chatRepository;
        this.profileRepository = profileRepository;
        this.chatParticipantRepository = chatParticipantRepository;
        this.messageRepository = messageRepository;
        this.currentUser = currentUser;
    }

    @Override
    public Chat getByChatId(Long chatId) {
        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isMemberOfTheChat = chatParticipantRepository
                .existsByChatIdAndProfileId(chatId, currentUser.getProfileId());

        if (!isAdmin && !isMemberOfTheChat) throw new NotAllowedException();

        Chat chat =  chatRepository.findById(chatId)
                .orElseThrow(() -> new NotFoundException("Chat not found"));

        List<ChatParticipant> participants = chatParticipantRepository
                .findByChatId(chatId, PageRequest.of(0, initParticipantSize));
        List<Message> messages = messageRepository
                .findByChatId(chatId, PageRequest.of(0, initMessagesSize));

        chat.setParticipants(participants);
        chat.setMessages(messages);
        return chat;
    }

    @Override
    @Transactional
    public Chat createChat(ChatCreateDTO chatCreateDTO) {
        Chat newChat = chatRepository.save(new Chat());
        saveCreator(newChat);
        saveParticipants(chatCreateDTO.getParticipantProfileIds(), newChat);
        return newChat;
    }

    private void saveCreator(Chat newChat) {
        Profile creatorProfile = profileRepository.findById(currentUser.getProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        ChatParticipant creator = chatParticipantRepository.save(
                ChatParticipant.builder()
                        .profile(creatorProfile)
                        .chat(newChat)
                        .isMod(true)
                        .build());

        newChat.setParticipants(List.of(creator));
    }

    private void saveParticipants(List<Long> participantProfileIds, Chat newChat) {
        if (participantProfileIds != null && !participantProfileIds.isEmpty()) {
            Iterable<Profile> profiles = profileRepository
                    .findAllById(participantProfileIds);

            List<ChatParticipant> chatParticipants = StreamSupport.stream(profiles.spliterator(), false)
                    .map(profile -> ChatParticipant.builder()
                            .profile(profile)
                            .chat(newChat)
                            .isMod(false)
                            .build())
                    .toList();

            List<ChatParticipant> participants = chatParticipantRepository.saveAll(chatParticipants);
            newChat.getParticipants().addAll(participants);
        }
    }

    @Override
    public void deleteChat(Long chatId) {
        if (!currentUser.hasRole(UserRole.ROLE_ADMIN)) {
            ChatParticipant deleter = chatParticipantRepository
                    .findByChatIdAndProfileId(chatId, currentUser.getProfileId())
                    .orElseThrow(NotParticipatedException::new);

            if (!deleter.isMod()) throw new NotAllowedException();
        }
        chatRepository.deleteById(chatId);
    }

    @Override
    public List<Chat> getChats(int page, long profileId) {
        if (profileId != 0 && currentUser.hasRole(UserRole.ROLE_ADMIN))
            return chatParticipantRepository.findChatsByProfileId(profileId, PageRequest.of(page, chatPageSize));
        return chatParticipantRepository.findChatsByProfileId(currentUser.getProfileId(), PageRequest.of(page, chatPageSize));
    }
}
