package com.service.delivery.application.service;

import com.service.delivery.application.exception.timeslot.InvalidTimeSlotException;
import com.service.delivery.application.exception.timeslot.NullTimeSlotException;
import com.service.delivery.application.ports.out.TimeSlotRepository;
import com.service.delivery.domain.model.TimeSlot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TimeSlotServiceImplTest {

    @Mock
    private TimeSlotRepository timeSlotRepository;

    @InjectMocks
    private TimeSlotServiceImpl timeSlotService;

    @Test
    void createTimeSlot_shouldReturnSavedTimeSlot_whenInputIsValid() {
        // Arrange
        TimeSlot timeSlot = createValidTimeSlot();
        when(timeSlotRepository.save(timeSlot)).thenReturn(timeSlot);

        // Act
        TimeSlot result = timeSlotService.createTimeSlot(timeSlot);

        // Assert
        assertNotNull(result);
        assertEquals(timeSlot, result);
        verify(timeSlotRepository, times(1)).save(timeSlot);
    }

    @Test
    void createTimeSlot_shouldThrowNullTimeSlotException_whenTimeSlotIsNull() {
        // Act & Assert
        assertThrows(NullTimeSlotException.class, () -> timeSlotService.createTimeSlot(null));
        verify(timeSlotRepository, never()).save(any());
    }

    @Test
    void createTimeSlot_shouldThrowInvalidTimeSlotException_whenStartTimeIsNull() {
        // Arrange
        TimeSlot timeSlot = new TimeSlot(UUID.randomUUID(), null, ZonedDateTime.now().plusHours(1), true);

        // Act & Assert
        assertThrows(InvalidTimeSlotException.class, () -> timeSlotService.createTimeSlot(timeSlot));
        verify(timeSlotRepository, never()).save(timeSlot);
    }

    @Test
    void createTimeSlot_shouldThrowInvalidTimeSlotException_whenEndTimeIsNull() {
        // Arrange
        TimeSlot timeSlot = new TimeSlot(UUID.randomUUID(), ZonedDateTime.now(), null, true);

        // Act & Assert
        assertThrows(InvalidTimeSlotException.class, () -> timeSlotService.createTimeSlot(timeSlot));
        verify(timeSlotRepository, never()).save(timeSlot);
    }

    @Test
    void getTimeSlotById_shouldReturnTimeSlot_whenTimeSlotExists() {
        // Arrange
        UUID id = UUID.randomUUID();
        TimeSlot timeSlot = createValidTimeSlot();
        when(timeSlotRepository.findById(id)).thenReturn(Optional.of(timeSlot));

        // Act
        Optional<TimeSlot> result = timeSlotService.getTimeSlotById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(timeSlot, result.get());
        verify(timeSlotRepository, times(1)).findById(id);
    }

    @Test
    void getTimeSlotById_shouldThrowNullTimeSlotException_whenIdIsNull() {
        // Act & Assert
        assertThrows(NullTimeSlotException.class, () -> timeSlotService.getTimeSlotById(null));
        verify(timeSlotRepository, never()).findById(any());
    }

    @Test
    void getTimeSlotById_shouldReturnEmptyOptional_whenTimeSlotDoesNotExist() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(timeSlotRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<TimeSlot> result = timeSlotService.getTimeSlotById(id);

        // Assert
        assertTrue(result.isEmpty());
        verify(timeSlotRepository, times(1)).findById(id);
    }

    @Test
    void getAllTimeSlots_shouldReturnAllTimeSlots() {
        // Arrange
        TimeSlot timeSlot = createValidTimeSlot();
        List<TimeSlot> timeSlots = List.of(timeSlot);
        when(timeSlotRepository.findAll()).thenReturn(timeSlots);

        // Act
        List<TimeSlot> result = timeSlotService.getAllTimeSlots();

        // Assert
        assertNotNull(result);
        assertEquals(timeSlots, result);
        assertEquals(timeSlot, result.getFirst());
        verify(timeSlotRepository, times(1)).findAll();
    }

    @Test
    void isTimeSlotAvailable_shouldReturnTrue_whenTimeSlotExists() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(timeSlotRepository.findById(id)).thenReturn(Optional.of(createValidTimeSlot()));

        // Act
        boolean result = timeSlotService.isTimeSlotAvailable(id);

        // Assert
        assertTrue(result);
        verify(timeSlotRepository, times(1)).findById(id);
    }

    @Test
    void isTimeSlotAvailable_shouldReturnFalse_whenTimeSlotDoesNotExist() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(timeSlotRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        boolean result = timeSlotService.isTimeSlotAvailable(id);

        // Assert
        assertFalse(result);
        verify(timeSlotRepository, times(1)).findById(id);
    }

    @Test
    void isTimeSlotAvailable_shouldThrowNullTimeSlotException_whenIdIsNull() {
        // Act & Assert
        assertThrows(NullTimeSlotException.class, () -> timeSlotService.isTimeSlotAvailable(null));
        verify(timeSlotRepository, never()).findById(any());
    }

    private TimeSlot createValidTimeSlot() {
        return new TimeSlot(UUID.randomUUID(), ZonedDateTime.now(), ZonedDateTime.now().plusHours(1), true);
    }
}