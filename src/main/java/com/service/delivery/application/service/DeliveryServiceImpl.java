package com.service.delivery.application.service;

import com.service.delivery.application.ports.in.DeliveryService;
import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
//@Service
//@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    // private final DeliveryRepository deliveryRepository;

    @Override
    public Delivery createDelivery(Delivery delivery) {
        return null; // TODO: Implement once repository is ready
    }

    @Override
    public Delivery getDeliveryById(UUID id) {
        return null;
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return List.of();
    }
}

