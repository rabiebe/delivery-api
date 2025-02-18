package com.service.delivery.application.service;

import com.service.delivery.application.ports.out.BookingRepository;
import com.service.delivery.domain.model.Booking;
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

    @Test
    void testGetBookingById() {
        Booking booking = new Booking(UUID.randomUUID(), null, null, null);
        when(bookingRepository.findById(booking.getId())).thenReturn(Optional.of(booking));

        Optional<Booking> result = bookingService.getBookingById(booking.getId());

        assertTrue(result.isPresent());
        assertEquals(booking, result.get());

        verify(bookingRepository, times(1)).findById(booking.getId());
    }

    @Test
    void testGetAllBookings() {
        Booking booking = new Booking(UUID.randomUUID(), null, null, null);
        List<Booking> bookings = List.of(booking);
        when(bookingRepository.findAll()).thenReturn(bookings);

        List<Booking> result = bookingService.getAllBookings();
        assertNotNull(result);
        assertEquals(booking, result.getFirst());
        verify(bookingRepository, times(1)).findAll();
    }
}
