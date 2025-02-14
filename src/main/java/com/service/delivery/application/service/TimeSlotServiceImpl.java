package com.service.delivery.application.service;

import com.service.delivery.application.ports.in.TimeSlotService;
import com.service.delivery.application.ports.out.TimeSlotRepository;
import com.service.delivery.domain.model.TimeSlot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;
    @Override
    public TimeSlot createTimeSlot(TimeSlot timeSlot) {
        return timeSlotRepository.save(timeSlot);
    }

    @Override
    public Optional<TimeSlot> getTimeSlotById(UUID id) {
        return timeSlotRepository.findById(id);
    }

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    @Override
    public boolean isTimeSlotAvailable(UUID id) {
        return false;
    }
}
