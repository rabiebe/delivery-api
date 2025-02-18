package com.service.delivery.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    private UUID id;

    @NotNull
    private UUID deliveryId;

    @NotNull
    private UUID timeSlotId;

    @NotNull
    private ZonedDateTime date;
}
