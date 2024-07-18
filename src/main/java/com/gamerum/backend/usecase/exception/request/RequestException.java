package com.gamerum.backend.usecase.exception.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class RequestException extends Exception{
    protected int status;
    protected String message;
}
