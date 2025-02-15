package com.service.delivery.infrastructure.inframapper;

import com.service.delivery.domain.model.TimeSlot;
import com.service.delivery.infrastructure.entity.TimeSlotEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InfrastructureTimeSlotMapper {
    InfrastructureTimeSlotMapper INSTANCE = Mappers.getMapper(InfrastructureTimeSlotMapper.class);
    TimeSlot toDomain(TimeSlotEntity entity);
    TimeSlotEntity toEntity(TimeSlot timeSlot);
}
