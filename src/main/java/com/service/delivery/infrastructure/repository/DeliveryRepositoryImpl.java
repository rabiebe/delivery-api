package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;
import com.service.delivery.infrastructure.repository.jpa.JpaDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final JpaDeliveryRepository deliveryJpaRepository;

//    void save(final Delivery delivery) {
//
//        deliveryJpaRepository.save()
//    }
}
