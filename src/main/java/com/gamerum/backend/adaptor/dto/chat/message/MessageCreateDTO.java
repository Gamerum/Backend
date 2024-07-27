package com.gamerum.backend.adaptor.dto.chat.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageCreateDTO {
    private Long senderProfileId;
    private String text;
    private boolean isSent;
}
