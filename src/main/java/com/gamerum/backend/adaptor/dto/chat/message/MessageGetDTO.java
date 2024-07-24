package com.gamerum.backend.adaptor.dto.chat.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MessageGetDTO {
    private Long senderId;
    private String senderName;
    private String message;
    private LocalDateTime sendDate;
    private boolean isSent;
}
