package com.service.delivery.web.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.ZonedDateTime;

public record DeliveryRequest(
        @NotNull(message = "Delivery mode is required")
        @NotBlank(message = "Delivery mode cannot be empty")
        String mode,

        @NotNull(message = "Delivery date is required")
        @Future(message = "Delivery date must be in the future")
        ZonedDateTime deliveryDate
) {}