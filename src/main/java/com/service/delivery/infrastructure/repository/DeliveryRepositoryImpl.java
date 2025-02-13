package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DeliveryRepositoryImpl implements DeliveryRepository {
    @Override
    public Delivery save(Delivery delivery) {
        return null;
    }

    @Override
    public Optional<Delivery> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Delivery> findAll() {
        return List.of();
    }
}
