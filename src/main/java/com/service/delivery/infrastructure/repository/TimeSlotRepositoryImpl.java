package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.TimeSlotRepository;
import com.service.delivery.domain.model.TimeSlot;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TimeSlotRepositoryImpl implements TimeSlotRepository {
    @Override
    public TimeSlot save(TimeSlot timeSlot) {
        return null;
    }

    @Override
    public Optional<TimeSlot> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<TimeSlot> findAll() {
        return List.of();
    }

    @Override
    public boolean isAvailable(UUID id) {
        return false;
    }
}
