package com.gamerum.backend.adaptor.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangePasswordDTO {
    private Long userId;
    private String currentPassword;
    private String newPassword;
}
