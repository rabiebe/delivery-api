package com.service.delivery.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotResponse {
    private UUID id;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
}
