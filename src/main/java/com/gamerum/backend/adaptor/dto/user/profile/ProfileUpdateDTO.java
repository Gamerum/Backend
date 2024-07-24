package com.gamerum.backend.adaptor.dto.user.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfileUpdateDTO {
    private Long id;
    private String nickname;
    private Long updaterProfileId;
}
