package com.service.delivery.application.service;

import com.service.delivery.application.ports.out.TimeSlotRepository;
import com.service.delivery.domain.model.TimeSlot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

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
        // Arrange
        TimeSlot timeSlot = new TimeSlot(UUID.randomUUID(), null, null, false);
        when(timeSlotRepository.save(timeSlot)).thenReturn(timeSlot);

        // Act
        TimeSlot result = timeSlotService.createTimeSlot(timeSlot);

        // Assert
        assertNotNull(result);
        assertEquals(timeSlot, result);

        // Verify interactions
        verify(timeSlotRepository, times(1)).save(timeSlot);
    }

    @Test
    void testFindTimeSlotById() {
        // Arrange
        UUID id = UUID.randomUUID();
        TimeSlot timeSlot = new TimeSlot(id, null, null, false);
        when(timeSlotRepository.findById(id)).thenReturn(java.util.Optional.of(timeSlot));

        // Act
        TimeSlot result = timeSlotService.getTimeSlotById(id).orElse(null);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());

        // Verify interactions
        verify(timeSlotRepository, times(1)).findById(id);
    }

    @Test
    void testGetAllTimeSlots(){
        //Arrange
        TimeSlot timeSlot = new TimeSlot(UUID.randomUUID(), null, null, false);
        when(timeSlotRepository.findAll()).thenReturn(List.of(timeSlot));

        //Act
        List<TimeSlot> result = timeSlotService.getAllTimeSlots();

        //Assert
        assertNotNull(result);
        assertEquals(timeSlot, result.getFirst());
        verify(timeSlotRepository, times(1)).findAll();
    }

    @Test
    void testIsTimeSlotAvailable() {
        //Arrange
        TimeSlot timeSlot = new TimeSlot(UUID.randomUUID(), null, null, false);
        when(timeSlotRepository.findById(timeSlot.getId())).thenReturn(Optional.of(timeSlot));

        //Act
        boolean result = timeSlotService.isTimeSlotAvailable(timeSlot.getId());

        //Assert
        assertTrue(result);

        //Verify interactions
        verify(timeSlotRepository, times(1)).findById(timeSlot.getId());
    }
}
