package com.service.delivery.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotRequest {
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
}
