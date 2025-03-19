package com.example.codewithmosh.common.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super("The book with ISBN " + message + " does not exist");
    }
}
