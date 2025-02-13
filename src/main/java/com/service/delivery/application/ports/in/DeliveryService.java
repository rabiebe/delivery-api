package com.service.delivery.application.ports.in;

import com.service.delivery.domain.model.Delivery;

import java.util.List;
import java.util.UUID;

public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);
    Delivery getDeliveryById(UUID id);
    List<Delivery> getAllDeliveries();
}
