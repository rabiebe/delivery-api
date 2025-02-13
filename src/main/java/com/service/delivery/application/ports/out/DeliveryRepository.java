package com.service.delivery.application.ports.out;

import com.service.delivery.domain.model.Delivery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository {
    Delivery save(Delivery delivery);
    Optional<Delivery> findById(UUID id);
    List<Delivery> findAll();
}
