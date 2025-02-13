package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.BookingRepository;
import com.service.delivery.domain.model.Booking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookingRepositoryImpl implements BookingRepository {
    @Override
    public Booking save(Booking booking) {
        return null;
    }

    @Override
    public Optional<Booking> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Booking> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }
}
