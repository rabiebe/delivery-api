package com.service.delivery.application.service;

import com.service.delivery.application.ports.in.BookingService;
import com.service.delivery.domain.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public Booking createBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking getBookingById(UUID id) {
        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        return List.of();
    }

    @Override
    public boolean cancelBooking(UUID id) {
        return false;
    }
}
