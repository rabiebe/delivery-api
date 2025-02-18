package com.service.delivery.application.service;

import com.service.delivery.application.exception.timeslot.InvalidTimeSlotException;
import com.service.delivery.application.exception.timeslot.NullTimeSlotException;
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
        if (timeSlot == null) {
            throw new NullTimeSlotException("TimeSlot cannot be null");
        }
        if (timeSlot.getStartTime() == null) {
            throw new InvalidTimeSlotException("Start time cannot be null");
        }
        if (timeSlot.getEndTime() == null) {
            throw new InvalidTimeSlotException("End time cannot be null");
        }
        return timeSlotRepository.save(timeSlot);
    }

    @Override
    public Optional<TimeSlot> getTimeSlotById(UUID id) {
        if (id == null) {
            throw new NullTimeSlotException("Id cannot be null");
        }
        return timeSlotRepository.findById(id);
    }

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    @Override
    public boolean isTimeSlotAvailable(UUID id) {
        if(id == null) {
            throw new NullTimeSlotException("Id cannot be null");
        }
        return timeSlotRepository.findById(id).isPresent();
    }
}
