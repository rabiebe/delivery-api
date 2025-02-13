package com.service.delivery.application.ports.in;


import com.service.delivery.domain.model.TimeSlot;
import java.util.List;
import java.util.UUID;

public interface TimeSlotService {
    TimeSlot createTimeSlot(TimeSlot timeSlot);
    TimeSlot getTimeSlotById(UUID id);
    List<TimeSlot> getAllTimeSlots();
    boolean isTimeSlotAvailable(UUID id);
}
