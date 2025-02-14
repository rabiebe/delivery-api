package com.service.delivery.infrastructure.repository.jpa;

import com.service.delivery.infrastructure.entity.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTimeSlotRepository extends JpaRepository<TimeSlotEntity, UUID> {

}
