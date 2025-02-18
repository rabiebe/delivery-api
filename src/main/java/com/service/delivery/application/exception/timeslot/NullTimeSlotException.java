package com.service.delivery.application.exception.timeslot;

public class NullTimeSlotException extends RuntimeException {
    public NullTimeSlotException(String message) {
        super(message);
    }
}
