package com.service.delivery.web.webmapper;

import com.service.delivery.domain.model.Booking;
import com.service.delivery.web.dto.request.BookingRequest;
import com.service.delivery.web.dto.response.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebBookingMapper {
    WebBookingMapper INSTANCE = Mappers.getMapper(WebBookingMapper.class);

    Booking toDomain(BookingRequest request);

    BookingResponse toResponse(Booking booking);
}
