package com.service.delivery.domain.exception.delivery;

public class InvalidDeliveryDateException extends RuntimeException {
    public InvalidDeliveryDateException(String message) {
        super(message);
    }
}
