package com.example.spring_crud_example_cities.exception;

public class OurException extends Exception{
    private String message;

    public OurException(String message) {
    }

    public String getMessage() {
        return message;
    }
}
