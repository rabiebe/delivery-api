package com.service.delivery.web.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;

public record TimeSlotRequest(
        @NotNull(message = "Start time is required")
        ZonedDateTime startTime,

        @NotNull(message = "End time is required")
        @Future(message = "End time must be in the future")
        ZonedDateTime endTime
) {}
