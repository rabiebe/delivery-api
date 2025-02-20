package com.service.delivery.web.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

public record BookingRequest(
        @NotNull(message = "Delivery ID is required")
        UUID deliveryId,

        @NotNull(message = "Time slot ID is required")
        UUID timeSlotId,

        @NotNull(message = "Booking date is required")
        @Future(message = "Booking date must be in the future")
        ZonedDateTime bookingDate
) {}
