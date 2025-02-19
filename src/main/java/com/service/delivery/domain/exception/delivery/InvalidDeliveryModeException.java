package com.service.delivery.domain.exception.delivery;

public class InvalidDeliveryModeException extends RuntimeException {
    public InvalidDeliveryModeException(String message) {
        super(message);
    }
}
