package com.gamerum.backend.adaptor.controller.chat;

import com.gamerum.backend.adaptor.dto.chat.ChatCreateDTO;
import com.gamerum.backend.adaptor.dto.chat.ChatGetDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.chat.ChatMapper;
import com.gamerum.backend.usecase.service.chat.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{chatId}")
    public ResponseEntity<ResponseData<ChatGetDTO>> getChat(
            @PathVariable Long chatId) {
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
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "0") Long profileId) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Chats received.",
                ChatMapper.INSTANCE.chatsToChatGetDTOs(chatService.getChats(page, profileId))),
                HttpStatus.OK);
    }
}