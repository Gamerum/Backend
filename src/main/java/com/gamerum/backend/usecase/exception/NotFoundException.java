package com.gamerum.backend.usecase.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entityName){
        super("Oops, no " + entityName + " here!");
    }
}
