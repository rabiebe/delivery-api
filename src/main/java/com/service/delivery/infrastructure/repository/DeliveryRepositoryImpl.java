package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;
import com.service.delivery.infrastructure.entity.DeliveryEntity;
import com.service.delivery.infrastructure.inframapper.InfrastructureDeliveryMapper;
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
    private final InfrastructureDeliveryMapper infrastructureDeliveryMapper;

    @Override
    public Delivery save(Delivery delivery) {
        DeliveryEntity entity = infrastructureDeliveryMapper.toEntity(delivery);
        return infrastructureDeliveryMapper.toDomain(deliveryJpaRepository.save(entity));
    }

    @Override
    public Optional<Delivery> findById(UUID id) {
        return deliveryJpaRepository.findById(id).map(infrastructureDeliveryMapper::toDomain);
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryJpaRepository.findAll().stream().map(infrastructureDeliveryMapper::toDomain).toList();
    }
}

