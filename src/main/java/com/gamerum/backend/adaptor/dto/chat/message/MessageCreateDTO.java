package com.gamerum.backend.adaptor.dto.chat.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageCreateDTO {
    private Long senderProfileId;
    private Long chatId;
    private String text;
}
