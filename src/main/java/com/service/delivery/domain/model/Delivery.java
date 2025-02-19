package com.service.delivery.domain.model;


import com.service.delivery.domain.exception.delivery.InvalidDeliveryDateException;
import com.service.delivery.domain.exception.delivery.InvalidDeliveryModeException;
import lombok.Getter;
import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
public class Delivery {

    private final UUID id;
    private final DeliveryMode mode;
    private final ZonedDateTime date;

    public Delivery(UUID id, DeliveryMode mode, ZonedDateTime date) {
        if (mode == null) {
            throw new InvalidDeliveryModeException("Delivery mode cannot be null.");
        }
        if (date == null || date.isBefore(ZonedDateTime.now())) {
            throw new InvalidDeliveryDateException("Delivery date must be in the future.");
        }
        this.id = id != null ? id : UUID.randomUUID();
        this.mode = mode;
        this.date = date;
    }
}


