package com.service.delivery.application.service.exception;

public class NullDeliveryException extends RuntimeException {
    public NullDeliveryException(String message) {
        super(message);
    }
}
