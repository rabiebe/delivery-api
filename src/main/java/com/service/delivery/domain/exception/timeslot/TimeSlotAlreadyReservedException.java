package com.service.delivery.domain.exception.timeslot;

public class TimeSlotAlreadyReservedException extends RuntimeException {
    public TimeSlotAlreadyReservedException(String message) {
        super(message);
    }
}
