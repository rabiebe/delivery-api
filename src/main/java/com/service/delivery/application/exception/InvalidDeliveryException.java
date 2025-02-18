package com.service.delivery.application.exception;

public class InvalidDeliveryException extends RuntimeException {
    public InvalidDeliveryException(String message) {
        super(message);
    }
}
