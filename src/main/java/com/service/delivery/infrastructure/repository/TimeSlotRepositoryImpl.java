package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.TimeSlotRepository;
import com.service.delivery.domain.model.TimeSlot;
import com.service.delivery.infrastructure.entity.TimeSlotEntity;
import com.service.delivery.infrastructure.mapper.TimeSlotMapper;
import com.service.delivery.infrastructure.repository.jpa.JpaTimeSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class TimeSlotRepositoryImpl implements TimeSlotRepository  {
    private final JpaTimeSlotRepository jpaTimeSlotRepository;
    private final TimeSlotMapper timeSlotMapper;

    @Override
    public TimeSlot save(TimeSlot timeSlot) {
        TimeSlotEntity entity = timeSlotMapper.toEntity(timeSlot);
        return timeSlotMapper.toDomain(jpaTimeSlotRepository.save(entity));
    }

    @Override
    public Optional<TimeSlot> findById(UUID id) {
        return jpaTimeSlotRepository.findById(id).map(timeSlotMapper::toDomain);
    }

    @Override
    public List<TimeSlot> findAll() {
        return jpaTimeSlotRepository.findAll().stream().map(timeSlotMapper::toDomain).toList();
    }
}
