package com.service.delivery.web.dto.request;

import com.service.delivery.web.validation.ValidZonedDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DeliveryRequest(
        @NotNull(message = "Delivery mode is required")
        @NotBlank(message = "Delivery mode cannot be empty")
        String mode,

        @NotNull(message = "Delivery date is required")
        @ValidZonedDateTime(message = "Invalid date format. Expected format: yyyy-MM-dd'T'HH:mm:ssXXX")
        String deliveryDate
) {}