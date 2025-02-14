package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;
import com.service.delivery.infrastructure.entity.DeliveryEntity;
import com.service.delivery.infrastructure.mapper.DeliveryMapper;
import com.service.delivery.infrastructure.repository.jpa.JpaDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final JpaDeliveryRepository deliveryJpaRepository;
    private final DeliveryMapper deliveryMapper;

    @Override
    public Delivery save(Delivery delivery) {
        DeliveryEntity entity = deliveryMapper.toEntity(delivery);
        return deliveryMapper.toDomain(deliveryJpaRepository.save(entity));
    }

    @Override
    public Optional<Delivery> findById(UUID id) {
        return deliveryJpaRepository.findById(id).map(deliveryMapper::toDomain);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryJpaRepository.findAll().stream().map(deliveryMapper::toDomain).toList();
    }
}

