package com.service.delivery.web.dto.request;

import com.service.delivery.domain.model.DeliveryMode;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;

public record DeliveryRequest(
        @NotNull(message = "Delivery mode is required")
        DeliveryMode mode,

        @NotNull(message = "Delivery date is required")
        @Future(message = "Delivery date must be in the future")
        ZonedDateTime deliveryDate
) {}