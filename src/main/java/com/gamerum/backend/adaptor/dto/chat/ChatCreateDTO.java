package com.gamerum.backend.adaptor.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatCreateDTO {
    private List<Long> participantProfileIds;
}
