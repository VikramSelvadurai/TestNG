package com.example.ngtest.user.add.repository;

public class ResourceAlreadyExistException extends Exception {
    public ResourceAlreadyExistException(final String message) {
        super(message);
    }
}
