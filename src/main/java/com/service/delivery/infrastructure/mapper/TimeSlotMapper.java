package com.service.delivery.infrastructure.mapper;

import com.service.delivery.domain.model.TimeSlot;
import com.service.delivery.infrastructure.entity.TimeSlotEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlotMapper INSTANCE = Mappers.getMapper(TimeSlotMapper.class);
    TimeSlot toDomain(TimeSlotEntity entity);
    TimeSlotEntity toEntity(TimeSlot timeSlot);
}
