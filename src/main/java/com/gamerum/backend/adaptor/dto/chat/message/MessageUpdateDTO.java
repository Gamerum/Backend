package com.gamerum.backend.adaptor.dto.chat.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessageUpdateDTO {
    private Long id;
    private String message;
}
