package com.service.delivery.web.controller;

import com.service.delivery.application.ports.in.TimeSlotService;
import com.service.delivery.domain.model.TimeSlot;
import com.service.delivery.web.dto.request.TimeSlotRequest;
import com.service.delivery.web.dto.response.TimeSlotResponse;
import com.service.delivery.web.webmapper.WebTimeSlotMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/timeslots")
@RequiredArgsConstructor
public class TimeSlotController {

    private final TimeSlotService timeSlotService;
    private final WebTimeSlotMapper timeSlotMapper;

    @PostMapping
    public ResponseEntity<TimeSlotResponse> createTimeSlot(@Valid @RequestBody TimeSlotRequest request) {
        TimeSlot timeSlot = timeSlotMapper.toDomain(request);
        TimeSlot createdTimeSlot = timeSlotService.createTimeSlot(timeSlot);
        return ResponseEntity.ok(timeSlotMapper.toResponse(createdTimeSlot));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlotResponse> getTimeSlotById(@PathVariable UUID id) {
        return timeSlotService.getTimeSlotById(id)
                .map(timeSlotMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TimeSlotResponse>> getAllTimeSlots() {
        List<TimeSlotResponse> timeSlots = timeSlotService.getAllTimeSlots()
                .stream()
                .map(timeSlotMapper::toResponse)
                .toList();
        return ResponseEntity.ok(timeSlots);
    }
}
