package com.service.delivery.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    private UUID deliveryId;
    private UUID timeSlotId;
    private ZonedDateTime bookingDate;
}
