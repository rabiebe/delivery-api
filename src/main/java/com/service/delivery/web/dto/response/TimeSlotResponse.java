package com.service.delivery.web.dto.response;

import java.time.ZonedDateTime;
import java.util.UUID;

public record TimeSlotResponse(
        UUID id,
        ZonedDateTime startTime,
        ZonedDateTime endTime,
        boolean available
) {}
