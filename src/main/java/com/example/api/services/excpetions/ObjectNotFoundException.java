package com.example.api.services.excpetions;

public class ObjectNotFoundException extends RuntimeException  {

    public ObjectNotFoundException(String message) {
        super(message);
    }
}

