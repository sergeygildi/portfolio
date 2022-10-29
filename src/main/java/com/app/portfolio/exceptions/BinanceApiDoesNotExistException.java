package com.app.portfolio.exceptions;

public class BinanceApiDoesNotExistException extends RuntimeException {
    public BinanceApiDoesNotExistException(String message) {
        super(message);
    }
}
