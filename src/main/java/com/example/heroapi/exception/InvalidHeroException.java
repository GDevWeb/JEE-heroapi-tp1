package com.example.heroapi.exception;

public class InvalidHeroException extends RuntimeException {
    public InvalidHeroException(final String message) {
        super(message);
    }
}