package com.gamerum.backend.adaptor.dto.community;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityCreateDTO {
    private String title;
    private String description;
    private String gameId;
}
