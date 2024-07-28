package com.gamerum.backend.usecase.service.chat.impl;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.external.persistence.relational.repository.ChatParticipantRepository;
import com.gamerum.backend.external.persistence.relational.repository.ChatRepository;
import com.gamerum.backend.external.persistence.relational.repository.ProfileRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.HasParticipateException;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.chat.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ChatParticipantRepository chatParticipantRepository;

    @Override
    public Chat getByChatId(Long chatId) {
        Optional<Chat> chat = chatRepository.findByIdWithParticipants(chatId);
        if (chat.isEmpty())
            throw new RuntimeException();
        return chat.get();
    }

    @Override
    public Chat createChat(ChatCreateDTO chat) {
        Profile creator = profileRepository.findById(chat.getCreatorProfileId())
                .orElseThrow(() -> new NotFoundException("Profile"));

        Chat newChat = chatRepository.save(new Chat(creator.getId()));

        //Set Chat Admin
        ChatParticipant admin = chatParticipantRepository.save(
                new ChatParticipant(creator, newChat, creator.getId(), true));
        newChat.getParticipants().add(admin);

        //Set Chat Participants
        if (chat.getParticipantProfileIds() != null) {
            List<ChatParticipant> chatParticipants = chat.getParticipantProfileIds().stream()
                    .map(id -> profileRepository.findById(id).orElseThrow(() ->
                            new NotFoundException("Profile")))
                    .map(profile -> new ChatParticipant(profile, newChat, creator.getId(), false))
                    .toList();
            List<ChatParticipant> participants = chatParticipantRepository.saveAll(chatParticipants);
            newChat.getParticipants().addAll(participants);
        }

        return newChat;
    }

    @Override
    public void deleteChat(Long chatId, Long deleterId) {
        if (deleterId != null) {
            Profile profile = profileRepository.findById(deleterId)
                    .orElseThrow(() -> new NotFoundException("Profile"));

            if (profile.getUser().getRole() == UserRole.ROLE_ADMIN) {
                chatRepository.deleteById(chatId);
                return;
            }

            ChatParticipant deleter = chatParticipantRepository
                    .findByChatIdAndProfileId(chatId, deleterId)
                    .orElseThrow(NotParticipatedException::new);

            if (!deleter.isAdmin())
                throw new NotAllowedException();

            chatRepository.deleteById(chatId);
            return;
        }

        if (chatParticipantRepository.countByChatId(chatId) != 0)
            throw new HasParticipateException();

        chatRepository.deleteById(chatId);
    }

    @Override
    public List<Chat> getChats(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return chatRepository.findAll(pageable).getContent();
    }
}
