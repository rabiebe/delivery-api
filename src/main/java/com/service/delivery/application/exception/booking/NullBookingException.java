package com.service.delivery.application.exception.booking;

public class NullBookingException extends RuntimeException {
    public NullBookingException(String message) {
        super(message);
    }
}
