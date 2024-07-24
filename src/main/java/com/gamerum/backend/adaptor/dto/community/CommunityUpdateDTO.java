package com.gamerum.backend.adaptor.dto.community;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommunityUpdateDTO {
    private Long id;
    private String title;
    private String description;
    private Long gameId;
    private String tags;
    private Long updaterProfileId;
}
