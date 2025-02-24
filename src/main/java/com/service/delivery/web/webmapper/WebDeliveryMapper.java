package com.service.delivery.web.webmapper;

import com.service.delivery.domain.model.Delivery;
import com.service.delivery.web.dto.request.DeliveryRequest;
import com.service.delivery.web.dto.response.DeliveryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebDeliveryMapper {
    WebDeliveryMapper INSTANCE = Mappers.getMapper(WebDeliveryMapper.class);

    default Delivery toDomain(DeliveryRequest request) {
        if (request == null) {
            return null;
        }
        return new Delivery(null, request.mode(), request.deliveryDate());
    }

    DeliveryResponse toResponse(Delivery delivery);
}
