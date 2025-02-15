package com.service.delivery.application.service;

import com.service.delivery.application.ports.out.BookingRepository;
import com.service.delivery.domain.model.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateBooking() {
        // Arrange
        Booking booking = new Booking(UUID.randomUUID(), null, null, null);
        when(bookingRepository.save(booking)).thenReturn(booking);

        // Act
        Booking result = bookingService.createBooking(booking);

        // Assert
        assertNotNull(result);
        assertEquals(booking, result);

        // Verify interactions
        verify(bookingRepository, times(1)).save(booking);
    }
}
