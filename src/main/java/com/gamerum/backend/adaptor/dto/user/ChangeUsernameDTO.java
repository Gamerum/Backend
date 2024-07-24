package com.gamerum.backend.adaptor.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangeUsernameDTO {
    private Long userId;
    private String newUsername;
    private Long updaterProfileId;
}
