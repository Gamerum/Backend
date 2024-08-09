package com.gamerum.backend.adaptor.dto.community;

import com.gamerum.backend.usecase.exception.ErrorCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityUpdateTagsDTO {
    @NotNull(message = ErrorCode.NOT_NULL)
    private List<String> tags;

    private boolean remove;
}
