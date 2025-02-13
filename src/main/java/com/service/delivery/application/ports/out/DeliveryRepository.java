package com.service.delivery.application.ports.out;


import com.service.delivery.infrastructure.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;


public interface DeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {

}
