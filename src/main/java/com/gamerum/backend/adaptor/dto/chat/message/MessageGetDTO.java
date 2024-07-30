package com.gamerum.backend.adaptor.dto.chat.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class MessageGetDTO {
    private Long senderProfileId;
    private String senderName;
    private String text;
    private Date sendDate;
    private boolean isSent;
}
