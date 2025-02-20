package com.service.delivery.domain.model;

import com.service.delivery.application.exception.timeslot.InvalidTimeSlotException;
import com.service.delivery.domain.exception.timeslot.TimeSlotAlreadyReservedException;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
public class TimeSlot {

    private final UUID id;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private final boolean isReserved;

    public TimeSlot(UUID id, ZonedDateTime startTime, ZonedDateTime endTime, boolean isReserved) {
        if (startTime == null || endTime == null) {
            throw new InvalidTimeSlotException("Start and End time cannot be null.");
        }
        if (endTime.isBefore(startTime)) {
            throw new InvalidTimeSlotException("End time must be after start time.");
        }
        this.id = id != null ? id : UUID.randomUUID();
        this.startTime = startTime;
        this.endTime = endTime;
        this.isReserved = isReserved;
    }

    public TimeSlot reserve() {
        if (isReserved) {
            throw new TimeSlotAlreadyReservedException("This time slot is already reserved.");
        }
        return new TimeSlot(this.id, this.startTime, this.endTime, true);
    }

    public boolean isAvailable() {
        return !isReserved;
    }
}
