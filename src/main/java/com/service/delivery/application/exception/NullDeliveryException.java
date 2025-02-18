package com.service.delivery.application.exception;

public class NullDeliveryException extends RuntimeException {
    public NullDeliveryException(String message) {
        super(message);
    }
}
