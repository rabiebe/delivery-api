package com.service.delivery.application.ports.out;

import com.service.delivery.domain.model.Delivery;
import com.service.delivery.domain.model.TimeSlot;
import com.service.delivery.infrastructure.entity.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TimeSlotRepository  {

    TimeSlot save(TimeSlot timeSlot);
    Optional<TimeSlot> findById(UUID id);
    List<TimeSlot> findAll();
}
