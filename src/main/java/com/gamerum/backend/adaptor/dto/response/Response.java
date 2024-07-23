package com.gamerum.backend.adaptor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response {
    protected boolean success;
    protected String message;
}
