package com.example.api.services.excpetions;

public class DataIntegrateViolationException extends RuntimeException  {

    public DataIntegrateViolationException(String message) {
        super(message);
    }
}

