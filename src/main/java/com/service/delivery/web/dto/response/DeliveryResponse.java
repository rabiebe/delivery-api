package com.service.delivery.web.dto.response;

import com.service.delivery.domain.model.DeliveryMode;
import java.time.ZonedDateTime;
import java.util.UUID;

public record DeliveryResponse(
        UUID id,
        DeliveryMode mode,
        ZonedDateTime deliveryDate
) {}
