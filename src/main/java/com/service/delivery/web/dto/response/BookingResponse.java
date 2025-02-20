package com.service.delivery.web.dto.response;

import java.time.ZonedDateTime;
import java.util.UUID;

public record BookingResponse(
        UUID id,
        UUID deliveryId,
        UUID timeSlotId,
        ZonedDateTime bookingDate
) {}
