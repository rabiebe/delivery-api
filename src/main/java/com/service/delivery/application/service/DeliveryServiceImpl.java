package com.service.delivery.application.service;

import com.service.delivery.application.exception.InvalidDeliveryException;
import com.service.delivery.application.exception.NullDeliveryException;
import com.service.delivery.application.ports.in.DeliveryService;
import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Override
    public Delivery createDelivery(Delivery delivery) {
        if (delivery == null) {
            throw new NullDeliveryException("Delivery cannot be null");
        }
        if (delivery.getMode() == null) {
            throw new InvalidDeliveryException("Mode cannot be null");
        }
        if (delivery.getDate() == null) {
            throw new InvalidDeliveryException("Date cannot be null");
        }
        return deliveryRepository.save(delivery);
    }

    @Override
    public Optional<Delivery> getDeliveryById(UUID id) {
        if (id == null) {
            throw new NullDeliveryException("ID cannot be null");
        }
        return deliveryRepository.findById(id);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }
}

