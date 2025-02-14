package com.service.delivery.infrastructure.mapper;

import com.service.delivery.domain.model.Booking;
import com.service.delivery.infrastructure.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);
    Booking toDomain(BookingEntity entity);
    BookingEntity toEntity(Booking booking);
}
