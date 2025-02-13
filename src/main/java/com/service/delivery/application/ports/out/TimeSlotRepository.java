package com.service.delivery.application.ports.out;

import com.service.delivery.infrastructure.entity.TimeSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TimeSlotRepository extends JpaRepository<TimeSlotEntity, UUID> {

}
