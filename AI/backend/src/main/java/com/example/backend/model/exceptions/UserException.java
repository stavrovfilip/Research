package com.example.backend.model.exceptions;

public class UserException extends RuntimeException{
    public UserException() {
        super("Please check the entered parameters again!");
    }
}
