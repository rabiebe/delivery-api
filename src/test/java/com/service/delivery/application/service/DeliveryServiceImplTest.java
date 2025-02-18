package com.service.delivery.application.service;

import com.service.delivery.application.ports.out.DeliveryRepository;
import com.service.delivery.domain.model.Delivery;
import com.service.delivery.domain.model.DeliveryMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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
        // Arrange
        Delivery delivery = new Delivery(UUID.randomUUID(), DeliveryMode.DRIVE, null);
        when(deliveryRepository.save(delivery)).thenReturn(delivery);

        // Act
        Delivery result = deliveryService.createDelivery(delivery);

        // Assert
        assertNotNull(result);
        assertEquals(delivery, result);

        // Verify interactions
        verify(deliveryRepository, times(1)).save(delivery);
    }

    @Test
    void testGetDeliveryById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Delivery delivery = new Delivery(id, DeliveryMode.DRIVE, null);
        when(deliveryRepository.findById(id)).thenReturn(Optional.of(delivery));

        // Act
        Optional<Delivery> result = deliveryService.getDeliveryById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(delivery, result.get());

        // Verify interactions
        verify(deliveryRepository, times(1)).findById(id);
    }

    @Test
    void testGetAllDeliveries(){
        //Arrange
        Delivery delivery = new Delivery(UUID.randomUUID(), DeliveryMode.DRIVE, null);
        List<Delivery> deliveries = List.of(delivery);

        when(deliveryRepository.findAll()).thenReturn(deliveries);

        //Act
        List<Delivery> result = deliveryService.getAllDeliveries();

        //Asset
        assertNotNull(result);
        assertEquals(deliveries, result);
        assertFalse(deliveries.isEmpty());

        //Verify interations
        verify(deliveryRepository, times(1)).findAll();
    }
}
