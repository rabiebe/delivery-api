package com.service.delivery.infrastructure.inframapper;

import com.service.delivery.domain.model.Booking;
import com.service.delivery.infrastructure.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InfrastructureBookingMapper {
    InfrastructureBookingMapper INSTANCE = Mappers.getMapper(InfrastructureBookingMapper.class);
    Booking toDomain(BookingEntity entity);
    BookingEntity toEntity(Booking booking);
}
