package com.service.delivery.web.controller;

import com.service.delivery.application.ports.in.TimeSlotService;
import com.service.delivery.web.dto.request.TimeSlotRequest;
import com.service.delivery.web.dto.response.TimeSlotResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/timeslots")
@RequiredArgsConstructor
public class TimeSlotController {

    //private final TimeSlotService timeSlotService;

    @PostMapping
    public ResponseEntity<Void> createTimeSlot(@RequestBody TimeSlotRequest request) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlotResponse> getTimeSlotById(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TimeSlotResponse>> getAllTimeSlots() {
        return ResponseEntity.ok().build();
    }
}
