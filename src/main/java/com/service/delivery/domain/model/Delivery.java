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
    private final ZonedDateTime deliveryDate;

    public Delivery(UUID id, DeliveryMode mode, ZonedDateTime deliveryDate) {
        if (mode == null) {
            throw new InvalidDeliveryModeException("Delivery mode cannot be null.");
        }
        if (deliveryDate == null || deliveryDate.isBefore(ZonedDateTime.now())) {
            throw new InvalidDeliveryDateException("Delivery date must be in the future.");
        }
        this.id = id != null ? id : UUID.randomUUID();
        this.mode = mode;
        this.deliveryDate = deliveryDate;
    }

    public Delivery updateDate(ZonedDateTime newDate) {
        if (newDate == null || newDate.isBefore(ZonedDateTime.now())) {
            throw new InvalidDeliveryDateException("New delivery date must be in the future.");
        }
        return new Delivery(this.id, this.mode, newDate);
    }
}


