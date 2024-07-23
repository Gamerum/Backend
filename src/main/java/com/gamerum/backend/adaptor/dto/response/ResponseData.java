package com.gamerum.backend.adaptor.dto.response;

import lombok.Getter;

@Getter
public class ResponseData<T> extends Response{
    private final T data;

    public ResponseData(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }
}
