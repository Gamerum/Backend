package com.gamerum.backend.adaptor.controller.chat;

import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantUpdateDTO;
import com.gamerum.backend.usecase.exception.ErrorResponse;
import com.gamerum.backend.adaptor.mapper.chat.ChatParticipantMapper;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat/{chatId}/participants")
public class ChatParticipantController {
    private final ChatParticipantService chatParticipantService;

    public ChatParticipantController(ChatParticipantService chatParticipantService) {
        this.chatParticipantService = chatParticipantService;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ChatParticipantGetDTO> addChatParticipant(@PathVariable Long chatId, @Validated @RequestBody ChatParticipantCreateDTO chatParticipantCreateDTO) {
        return new ResponseEntity<>(ChatParticipantMapper.INSTANCE.chatParticipantToChatParticipantGetDTO(chatParticipantService.createChatParticipant(chatId, chatParticipantCreateDTO)), HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping
    public ResponseEntity<ErrorResponse> deleteChatParticipant(@PathVariable Long chatId, @RequestParam Long chatParticipantId) {
        chatParticipantService.deleteByIdChatParticipant(chatId, chatParticipantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping
    public ResponseEntity<List<ChatParticipantGetDTO>> getChatParticipants(@PathVariable Long chatId, @RequestParam(defaultValue = "0") Integer page) {
        return new ResponseEntity<>(ChatParticipantMapper.INSTANCE.chatParticipantsToChatParticipantGetDTOs(chatParticipantService.getChatParticipants(chatId, page)), HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<ChatParticipantGetDTO> updateChatParticipant(@PathVariable Long chatId, @Validated @RequestBody ChatParticipantUpdateDTO chatParticipantUpdateDTO) {
        return new ResponseEntity<>(ChatParticipantMapper.INSTANCE.chatParticipantToChatParticipantGetDTO(chatParticipantService.updateChatParticipant(chatId, chatParticipantUpdateDTO)), HttpStatus.OK);
    }
}
