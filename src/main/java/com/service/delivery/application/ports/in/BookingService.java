package com.service.delivery.application.ports.in;

import com.service.delivery.domain.model.Booking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//
public interface BookingService {
    Booking createBooking(Booking booking);
    Optional<Booking> getBookingById(UUID id);
    List<Booking> getAllBookings();
    boolean cancelBooking(UUID id);
}
