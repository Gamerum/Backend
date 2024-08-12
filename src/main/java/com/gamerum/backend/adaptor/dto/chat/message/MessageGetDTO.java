package com.gamerum.backend.adaptor.dto.chat.message;

import com.gamerum.backend.external.persistence.relational.entity.chat.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class MessageGetDTO {
    private Long senderProfileId;
    private String senderName;
    private String text;
    private Message.Type type;
    private Date sendDate;
    private boolean isSent;
}
