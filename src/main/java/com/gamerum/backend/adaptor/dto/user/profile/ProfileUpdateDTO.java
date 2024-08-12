package com.gamerum.backend.adaptor.dto.user.profile;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUpdateDTO {
    @Size(min = 6, max = 30, message = MessageCode.SIZE_EXCEPTION_6_30)
    private String nickname;
}
