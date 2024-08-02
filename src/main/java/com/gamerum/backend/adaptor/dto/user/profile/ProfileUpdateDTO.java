package com.gamerum.backend.adaptor.dto.user.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateDTO {
    private Long id;
    private String nickname;
}
