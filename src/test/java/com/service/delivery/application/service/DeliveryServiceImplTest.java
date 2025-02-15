package com.service.delivery.application.service;

import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;
import com.service.delivery.domain.model.DeliveryMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class DeliveryServiceImplTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryServiceImpl deliveryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateDelivery() {
        Delivery delivery = new Delivery(UUID.randomUUID(), DeliveryMode.DRIVE, null);
        when(deliveryRepository.save(delivery)).thenReturn(delivery);

        Delivery result = deliveryService.createDelivery(delivery);
        assertNotNull(result);
        assertEquals(delivery, result);
    }

    @Test
    void testGetDeliveryById() {
        UUID id = UUID.randomUUID();
        Delivery delivery = new Delivery(id, DeliveryMode.DRIVE, null);
        when(deliveryRepository.findById(id)).thenReturn(Optional.of(delivery));

        Optional<Delivery> result = deliveryService.getDeliveryById(id);
        assertTrue(result.isPresent());
        assertEquals(delivery, result.get());
    }
}

