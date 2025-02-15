package com.service.delivery.application.service;

import com.service.delivery.application.ports.out.TimeSlotRepository;
import com.service.delivery.domain.model.TimeSlot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
public class TimeSlotServiceImplTest {

    @Mock
    private TimeSlotRepository timeSlotRepository;

    @InjectMocks
    private TimeSlotServiceImpl timeSlotService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTimeSlot() {
        TimeSlot timeSlot = new TimeSlot(UUID.randomUUID(), null, null, false);
        when(timeSlotRepository.save(timeSlot)).thenReturn(timeSlot);

        TimeSlot result = timeSlotService.createTimeSlot(timeSlot);
        assertNotNull(result);
        assertEquals(timeSlot, result);
    }
}
