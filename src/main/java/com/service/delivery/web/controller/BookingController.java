package com.service.delivery.web.controller;

import com.service.delivery.application.ports.in.BookingService;
import com.service.delivery.domain.model.Booking;
import com.service.delivery.web.dto.request.BookingRequest;
import com.service.delivery.web.dto.response.BookingResponse;
import com.service.delivery.web.webmapper.WebBookingMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final WebBookingMapper bookingMapper;

    @PostMapping
    public ResponseEntity<BookingResponse> createBooking(@Valid @RequestBody BookingRequest request) {
        Booking booking = bookingMapper.toDomain(request);
        Booking createdBooking = bookingService.createBooking(booking);
        return ResponseEntity.ok(bookingMapper.toResponse(createdBooking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable UUID id) {
        return bookingService.getBookingById(id)
                .map(bookingMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        List<BookingResponse> bookings = bookingService.getAllBookings()
                .stream()
                .map(bookingMapper::toResponse)
                .toList();
        return ResponseEntity.ok(bookings);
    }
}
