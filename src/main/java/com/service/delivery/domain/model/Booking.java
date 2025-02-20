package com.service.delivery.domain.model;

import com.service.delivery.application.exception.booking.InvalidBookingException;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
public class Booking {
    private UUID id;

    private UUID deliveryId;

    private UUID timeSlotId;

    private ZonedDateTime date;

    public Booking(UUID id, UUID deliveryId, UUID timeSlotId, ZonedDateTime date) {
        if (deliveryId == null || timeSlotId == null) {
            throw new InvalidBookingException("Delivery ID and Time Slot ID cannot be null.");
        }
        if (date == null || date.isBefore(ZonedDateTime.now())) {
            throw new InvalidBookingException("Booking date must be in the future.");
        }
        this.id = id != null ? id : UUID.randomUUID();
        this.deliveryId = deliveryId;
        this.timeSlotId = timeSlotId;
        this.date = date;
    }

    public Booking updateDate(ZonedDateTime newDate) {
        if (newDate == null || newDate.isBefore(ZonedDateTime.now())) {
            throw new InvalidBookingException("New booking date must be in the future.");
        }
        return new Booking(this.id, this.deliveryId, this.timeSlotId, newDate);
    }
}
