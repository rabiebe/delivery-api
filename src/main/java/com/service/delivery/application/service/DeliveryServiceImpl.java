package com.service.delivery.application.service;

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
        try{
            if (delivery == null) {throw new Exception("Delivery cannot be null");}
            if(delivery.getMode() == null) {throw new Exception("Mode cannot be null");}
            if(delivery.getDate() == null) {throw new Exception("Date cannot be null");}
            return deliveryRepository.save(delivery);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Delivery> getDeliveryById(UUID id) {
        try {
            if (id == null) {throw new Exception("ID cannot be null");}
            return deliveryRepository.findById(id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }
}

