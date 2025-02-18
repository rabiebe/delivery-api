package com.service.delivery.application.service;


import com.service.delivery.application.exception.booking.InvalidBookingException;
import com.service.delivery.application.exception.booking.NullBookingException;
import com.service.delivery.application.ports.out.BookingRepository;
import com.service.delivery.domain.model.Booking;
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
public class BookingServiceImplTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    void createBooking_shouldReturnSavedBooking_whenInputIsValid() {
        // Arrange
        Booking booking = createValidBooking();
        when(bookingRepository.save(booking)).thenReturn(booking);

        // Act
        Booking result = bookingService.createBooking(booking);

        // Assert
        assertNotNull(result);
        assertEquals(booking, result);
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void createBooking_shouldThrowNullBookingException_whenBookingIsNull() {
        // Act & Assert
        assertThrows(NullBookingException.class, () -> bookingService.createBooking(null));
        verify(bookingRepository, never()).save(any());
    }

    @Test
    void createBooking_shouldThrowInvalidBookingException_whenDateIsNull() {
        // Arrange
        Booking booking = new Booking(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), null);

        // Act & Assert
        assertThrows(InvalidBookingException.class, () -> bookingService.createBooking(booking));
        verify(bookingRepository, never()).save(any());
    }

    @Test
    void getBookingById_shouldReturnBooking_whenBookingExists() {
        // Arrange
        UUID id = UUID.randomUUID();
        Booking booking = createValidBooking();
        when(bookingRepository.findById(id)).thenReturn(Optional.of(booking));

        // Act
        Optional<Booking> result = bookingService.getBookingById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(booking, result.get());
        verify(bookingRepository, times(1)).findById(id);
    }

    @Test
    void getBookingById_shouldReturnEmptyOptional_whenBookingDoesNotExist() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(bookingRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<Booking> result = bookingService.getBookingById(id);

        // Assert
        assertTrue(result.isEmpty());
        verify(bookingRepository, times(1)).findById(id);
    }

    @Test
    void getAllBookings_shouldReturnAllBookings() {
        // Arrange
        Booking booking = createValidBooking();
        List<Booking> bookings = List.of(booking);
        when(bookingRepository.findAll()).thenReturn(bookings);

        // Act
        List<Booking> result = bookingService.getAllBookings();

        // Assert
        assertNotNull(result);
        assertEquals(bookings, result);
        assertEquals(booking, result.getFirst());
        verify(bookingRepository, times(1)).findAll();
    }

    @Test
    void cancelBooking_shouldReturnTrue_whenBookingIsCancelled() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(bookingRepository.deleteById(id)).thenReturn(true);

        // Act
        boolean result = bookingService.cancelBooking(id);

        // Assert
        assertTrue(result);
        verify(bookingRepository, times(1)).deleteById(id);
    }

    @Test
    void cancelBooking_shouldReturnFalse_whenBookingDoesNotExist() {
        // Arrange
        UUID id = UUID.randomUUID();
        when(bookingRepository.deleteById(id)).thenReturn(false);

        // Act
        boolean result = bookingService.cancelBooking(id);

        // Assert
        assertFalse(result);
        verify(bookingRepository, times(1)).deleteById(id);
    }

    private Booking createValidBooking() {
        return new Booking(
                UUID.randomUUID(),
                UUID.randomUUID(),
                UUID.randomUUID(),
                ZonedDateTime.now()
        );
    }
}
