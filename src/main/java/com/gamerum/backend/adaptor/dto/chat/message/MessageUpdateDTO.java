package com.gamerum.backend.adaptor.dto.chat.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageUpdateDTO {
    private String message;
    private Long updaterProfileId;
}