package com.apifirst.test.price.application.exception;


public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(final String message) {
        super(message);
    }
}
