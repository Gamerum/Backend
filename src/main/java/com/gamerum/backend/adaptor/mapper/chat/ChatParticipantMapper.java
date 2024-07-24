package com.gamerum.backend.adaptor.mapper.chat;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper
public interface ChatParticipantMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "profile.nickname", target = "nickname")
    @Mapping(source = "admin", target = "isAdmin")
    ChatParticipantGetDTO chatParticipantToChatParticipantGetDTO(ChatParticipant chatParticipant);

    Set<ChatParticipantGetDTO> chatParticipantsToChatParticipantGetDTOs(Set<ChatParticipant> chatParticipants);
}
