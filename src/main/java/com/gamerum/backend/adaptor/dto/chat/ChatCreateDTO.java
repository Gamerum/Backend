package com.gamerum.backend.adaptor.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class ChatCreateDTO {
    private Set<Long> profileIds;
    private Long creatorProfileId;
}
