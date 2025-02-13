package com.service.delivery.application.ports.out;

import com.service.delivery.domain.model.TimeSlot;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TimeSlotRepository {
    TimeSlot save(TimeSlot timeSlot);
    Optional<TimeSlot> findById(UUID id);
    List<TimeSlot> findAll();
    boolean isAvailable(UUID id);
}
