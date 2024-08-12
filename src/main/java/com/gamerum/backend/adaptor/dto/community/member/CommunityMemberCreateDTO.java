package com.gamerum.backend.adaptor.dto.community.member;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityMemberCreateDTO {
    @NotNull(message = MessageCode.NOT_NULL)
    private Long profileId;
}
