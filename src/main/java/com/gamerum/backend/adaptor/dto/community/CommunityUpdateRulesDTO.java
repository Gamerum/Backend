package com.gamerum.backend.adaptor.dto.community;

import com.gamerum.backend.usecase.utils.MessageCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommunityUpdateRulesDTO {
    @NotNull(message = MessageCode.NOT_NULL)
    private List<String> rules;

    private boolean remove;
}
