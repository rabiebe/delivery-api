package com.service.delivery.application.ports.in;

import com.service.delivery.domain.model.Booking;

import java.util.List;
import java.util.UUID;

//
public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(UUID id);
    List<Booking> getAllBookings();
    boolean cancelBooking(UUID id);
}
