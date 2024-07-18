package com.gamerum.backend.usecase.exception.request;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestException extends Exception{
    protected int status;
    protected String message;
}
