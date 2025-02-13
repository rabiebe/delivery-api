package com.service.delivery.domain.model;


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
    private DeliveryMode mode;
    private ZonedDateTime date;
}

