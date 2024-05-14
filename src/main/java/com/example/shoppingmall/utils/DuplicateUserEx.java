package com.example.shoppingmall.utils;

public class DuplicateUserEx extends RuntimeException {
//public class DuplicateUserEx extends Exception {
    String message;

    public DuplicateUserEx(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}