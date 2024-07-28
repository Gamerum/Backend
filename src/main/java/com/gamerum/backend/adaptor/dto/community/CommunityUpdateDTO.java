package com.gamerum.backend.adaptor.dto.community;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunityUpdateDTO {
    private String title;
    private String description;
    private String tags;
}
