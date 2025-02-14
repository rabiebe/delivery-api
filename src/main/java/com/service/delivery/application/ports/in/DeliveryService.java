package com.service.delivery.application.ports.in;

import com.service.delivery.domain.model.Delivery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);
    Optional<Delivery> getDeliveryById(UUID id);
    List<Delivery> getAllDeliveries();
}
