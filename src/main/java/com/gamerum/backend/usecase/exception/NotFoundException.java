package com.gamerum.backend.usecase.exception;

public class NotFoundException extends RuntimeException {
    public <Entity> NotFoundException(Class<Entity> clazz, String searchParam, Object value){
        super(searchParam + " " + value + " not found in" + clazz.getSimpleName());
    }
}
