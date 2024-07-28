package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.ChatGetDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageGetDTO;
import com.gamerum.backend.adaptor.dto.chat.message.MessageUpdateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantGetDTO;
import com.gamerum.backend.adaptor.dto.chat.participant.ChatParticipantUpdateDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.chat.ChatMapper;
import com.gamerum.backend.adaptor.mapper.chat.ChatParticipantMapper;
import com.gamerum.backend.adaptor.mapper.chat.MessageMapper;
import com.gamerum.backend.usecase.service.chat.ChatParticipantService;
import com.gamerum.backend.usecase.service.chat.ChatService;
import com.gamerum.backend.usecase.service.chat.MessageService;
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

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{chatId}")
    public ResponseEntity<ResponseData<ChatGetDTO>> getChatById(
            @PathVariable long chatId) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Chat received.",
                ChatMapper.INSTANCE.chatToChatGetDTO(chatService.getByChatId(chatId))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<ChatGetDTO>> createChat(@RequestBody ChatCreateDTO chatCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(true,
                "Chat created.",
                ChatMapper.INSTANCE.chatToChatGetDTO(chatService.createChat(chatCreateDTO))),
                HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{chatId}")
    public ResponseEntity<Response> deleteChat(@PathVariable Long chatId) {
        chatService.deleteChat(chatId);
        return new ResponseEntity<>(new Response(
                true,
                "Chat deleted."),
                HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping
    public ResponseEntity<ResponseData<List<ChatGetDTO>>> getChats(
            @RequestParam int size,
            @RequestParam(required = false) int page,
            @RequestParam(required = false) long profileId) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Chats received.",
                ChatMapper.INSTANCE.chatsToChatGetDTOs(chatService.getChats(page, size, profileId))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
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

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{chatId}/participants")
    public ResponseEntity<Response> deleteChatParticipant(
            @PathVariable Long chatId,
            @RequestParam Long chatParticipantId) {
        chatParticipantService.deleteByIdChatParticipant(chatId, chatParticipantId);
        return new ResponseEntity<>(new Response(
                true,
                "Participant removed."),
                HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{chatId}/participants")
    public ResponseEntity<ResponseData<List<ChatParticipantGetDTO>>> getChatParticipants(
            @PathVariable Long chatId,
            @RequestParam(required = false) int page,
            @RequestParam int size) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Participants received.",
                ChatParticipantMapper.INSTANCE.chatParticipantsToChatParticipantGetDTOs(
                        chatParticipantService.getChatParticipants(chatId, page, size))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{chatId}/participants")
    public ResponseEntity<ResponseData<ChatParticipantGetDTO>> updateChatParticipant(
            @PathVariable Long chatId,
            @RequestBody ChatParticipantUpdateDTO chatParticipantUpdateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Participant updated",
                ChatParticipantMapper.INSTANCE.chatParticipantToChatParticipantGetDTO(
                        chatParticipantService.updateChatParticipant(chatId, chatParticipantUpdateDTO))),
                HttpStatus.OK
        );
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/{chatId}/messages")
    public ResponseEntity<ResponseData<MessageGetDTO>> addMessage(
            @PathVariable Long chatId,
            @RequestBody MessageCreateDTO messageCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Message saved.",
                MessageMapper.INSTANCE.messageToMessageGetDTO(
                        messageService.createMessage(chatId, messageCreateDTO))),
                HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{chatId}/messages")
    public ResponseEntity<Response> deleteMessage(
            @PathVariable Long chatId,
            @RequestParam Long messageId) {
        messageService.deleteByIdMessage(chatId, messageId);
        return new ResponseEntity<>(new Response(
                true,
                "Message deleted."),
                HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{chatId}/messages")
    public ResponseEntity<ResponseData<List<MessageGetDTO>>> getAllMessages(
            @PathVariable Long chatId,
            @RequestParam(required = false) int page,
            @RequestParam int size) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Messages received.",
                MessageMapper.INSTANCE.messagesToMessageGetDTOs(
                        messageService.getAllMessages(chatId, page, size))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{chatId}/messages")
    public ResponseEntity<ResponseData<MessageGetDTO>> updateMessage(
            @PathVariable Long chatId,
            @RequestBody MessageUpdateDTO messageUpdateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Message updated.",
                MessageMapper.INSTANCE.messageToMessageGetDTO(
                        messageService.updateMessage(chatId, messageUpdateDTO))),
                HttpStatus.OK);
    }
}