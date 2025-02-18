package com.service.delivery.application.service;

import com.service.delivery.application.exception.booking.InvalidBookingException;
import com.service.delivery.application.exception.booking.NullBookingException;
import com.service.delivery.application.ports.in.BookingService;
import com.service.delivery.application.ports.out.BookingRepository;
import com.service.delivery.domain.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        if(booking == null) {
            throw new NullBookingException("Booking is null");
        }
        if(booking.getDate() == null) {
            throw new InvalidBookingException("Date cannot be null");
        }
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBookingById(UUID id) {
        if (id == null) {
            throw new NullBookingException("Id cannot be null");
        }
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public boolean cancelBooking(UUID id) {
        if (id == null) {
            throw new NullBookingException("Id cannot be null");
        }
        return bookingRepository.deleteById(id);
    }
}
