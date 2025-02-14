package com.service.delivery.infrastructure.repository.jpa;

import com.service.delivery.infrastructure.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaDeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {
}
