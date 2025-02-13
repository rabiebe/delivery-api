package com.service.delivery.application.service;

import com.service.delivery.application.ports.in.TimeSlotService;
import com.service.delivery.domain.model.TimeSlot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {
    @Override
    public TimeSlot createTimeSlot(TimeSlot timeSlot) {
        return null;
    }

    @Override
    public TimeSlot getTimeSlotById(UUID id) {
        return null;
    }

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return List.of();
    }

    @Override
    public boolean isTimeSlotAvailable(UUID id) {
        return false;
    }
}
