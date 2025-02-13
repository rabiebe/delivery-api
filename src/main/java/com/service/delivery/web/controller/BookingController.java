package com.service.delivery.web.controller;

import com.service.delivery.application.ports.in.BookingService;
import com.service.delivery.web.dto.request.BookingRequest;
import com.service.delivery.web.dto.response.BookingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    //private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Void> createBooking(@RequestBody BookingRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }
}
