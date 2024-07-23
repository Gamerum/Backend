package com.gamerum.backend.adaptor.mapper;

import com.gamerum.backend.adaptor.dto.chat.ChatGetDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.Chat;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "chatParticipants", target = "chatParticipants")
    @Mapping(source = "messages", target = "messages")
    ChatGetDTO chatToChatGetDTO(Chat chat);

    @Mapping(source = "profile.id", target = "profileId")
    @Mapping(source = "profile.nickname", target = "nickname")
    @Mapping(source = "admin", target = "isAdmin")
    ChatParticipantGetDTO chatParticipantToChatParticipantGetDTO(ChatParticipant chatParticipant);

    @Mapping(source = "profile.id", target = "senderId")
    @Mapping(source = "profile.nickname", target = "senderName")
    @Mapping(source = "content", target = "message")
    @Mapping(source = "createdAt", target = "sendDate")
    @Mapping(source = "sent", target = "isSent")
    MessageGetDTO messageToMessageGetDTO(Message message);

    List<ChatParticipantGetDTO> chatParticipantsToChatParticipantGetDTOs(Set<ChatParticipant> chatParticipants);

    List<MessageGetDTO> messagesToMessageGetDTOs(List<Message> messages);

}
