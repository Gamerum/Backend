package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.ChatGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.chat.ChatMapper;
import com.gamerum.backend.adaptor.mapper.chat.ChatParticipantMapper;
import com.gamerum.backend.external.persistence.relational.entity.ChatParticipant;
import com.gamerum.backend.external.persistence.relational.entity.Message;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import com.gamerum.backend.usecase.service.chat.ChatService;
import com.gamerum.backend.usecase.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private ChatParticipantService chatParticipantService;
    @Autowired
    private MessageService messageService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{chatId}")
    public ResponseEntity<ResponseData<ChatGetDTO>> getChatById(@PathVariable Long chatId) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Chat received.",
                ChatMapper.INSTANCE.chatToChatGetDTO(chatService.getByChatId(chatId))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<ChatGetDTO>> createChat(@RequestBody ChatCreateDTO chatCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(true,
                "Chat created.",
                ChatMapper.INSTANCE.chatToChatGetDTO(chatService.createChat(chatCreateDTO))),
                HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/{chatId}")
    public ResponseEntity<Response> deleteChat(@PathVariable Long chatId) {
        chatService.deleteChat(chatId);
        return new ResponseEntity<>(new Response(
                true,
                "Chat deleted."),
                HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public ResponseEntity<ResponseData<List<ChatGetDTO>>> getChats(@RequestParam(required = false) int page,
                                                                   @RequestParam int size) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Chats received.",
                ChatMapper.INSTANCE.chatsToChatGetDTOs(chatService.getChats(page, size))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping("/{chatId}/participants")
    public ResponseEntity<ResponseData<ChatParticipantGetDTO>> addChatParticipant(
            @PathVariable long chatId,
            @RequestBody ChatParticipantCreateDTO chatParticipantCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Participant added.",
                ChatParticipantMapper.INSTANCE.chatParticipantToChatParticipantGetDTO(
                        chatParticipantService.createChatParticipant(chatId, chatParticipantCreateDTO))),
                HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/{chatId}/participants")
    public ResponseEntity<Response> deleteChatParticipant(
            @PathVariable Long chatId,
            @RequestParam Long chatParticipantId,
            @RequestParam Long deleterProfileId) {
        chatParticipantService.deleteByIdChatParticipant(chatId, chatParticipantId, deleterProfileId);
        return new ResponseEntity<>(new Response(
                true,
                "Participant removed."),
                HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/participants")
    public ResponseEntity<List<ChatParticipant>> getChatParticipants() {
        return new ResponseEntity<>(chatParticipantService.getChatParticipants(),HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping("/messages")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.createMessage(message),HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long mesaageId) {
        messageService.deleteByIdMessage(mesaageId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/messages/{id}")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable Long chatId) {
        return new ResponseEntity<>(messageService.getAllMessages(chatId),HttpStatus.OK);
    }
}