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
public class Delivery {
    private UUID id;

    @NotNull
    private DeliveryMode mode;

    @NotNull
    private ZonedDateTime date;
}

