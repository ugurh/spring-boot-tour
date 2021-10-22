package com.example.introduction.handler;

public class ProductNotfoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public ProductNotfoundException() {
        this.message = "Not Found";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
