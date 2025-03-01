package com.service.delivery.web.mapper;

import com.service.delivery.domain.model.Delivery;
import com.service.delivery.web.dto.request.DeliveryRequest;
import com.service.delivery.web.dto.response.DeliveryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    Delivery toDomain(DeliveryRequest request);

    DeliveryResponse toResponse(Delivery delivery);
}
