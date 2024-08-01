package com.gamerum.backend.adaptor.mapper.chat;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ChatParticipantMapper {
    ChatParticipantMapper INSTANCE = Mappers.getMapper(ChatParticipantMapper.class);

    @Mapping(source = "profile.nickname", target = "nickname")
    @Mapping(source = "mod", target = "isMod")
    ChatParticipantGetDTO chatParticipantToChatParticipantGetDTO(ChatParticipant chatParticipant);

    List<ChatParticipantGetDTO> chatParticipantsToChatParticipantGetDTOs(List<ChatParticipant> chatParticipants);
}
