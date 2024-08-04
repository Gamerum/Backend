package com.gamerum.backend.adaptor.dto.community.member;

import com.gamerum.backend.usecase.exception.ErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityMemberCreateDTO {
    @NotNull(message = ErrorCode.NOT_NULL)
    private Long profileId;
}
