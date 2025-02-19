package com.service.delivery.domain.model;

import com.service.delivery.application.exception.timeslot.InvalidTimeSlotException;
import com.service.delivery.domain.exception.timeslot.TimeSlotAlreadyReservedException;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
public class TimeSlot {

    private final UUID id;
    private final ZonedDateTime startTime;
    private final ZonedDateTime endTime;
    private boolean reserved;

    public TimeSlot(UUID id, ZonedDateTime startTime, ZonedDateTime endTime, boolean reserved) {
        if (startTime == null || endTime == null) {
            throw new InvalidTimeSlotException("Start and End time cannot be null.");
        }
        if (endTime.isBefore(startTime)) {
            throw new InvalidTimeSlotException("End time must be after start time.");
        }
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reserved = reserved;
    }

    public void reserve() {
        if (reserved) {
            throw new TimeSlotAlreadyReservedException("This time slot is already reserved.");
        }
        this.reserved = true;
    }

    public boolean isAvailable() {
        return !reserved;
    }
}
