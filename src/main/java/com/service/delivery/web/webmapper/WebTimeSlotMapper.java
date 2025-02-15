package com.service.delivery.web.mapper;

import com.service.delivery.domain.model.TimeSlot;
import com.service.delivery.web.dto.request.TimeSlotRequest;
import com.service.delivery.web.dto.response.TimeSlotResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebTimeSlotMapper {
    WebTimeSlotMapper INSTANCE = Mappers.getMapper(WebTimeSlotMapper.class);

    TimeSlot toDomain(TimeSlotRequest request);

    TimeSlotResponse toResponse(TimeSlot timeSlot);
}
