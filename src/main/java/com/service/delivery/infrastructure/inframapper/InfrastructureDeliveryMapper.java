package com.service.delivery.infrastructure.mapper;

import com.service.delivery.domain.model.Delivery;
import com.service.delivery.infrastructure.entity.DeliveryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InfrastructureDeliveryMapper {
    InfrastructureDeliveryMapper INSTANCE = Mappers.getMapper(InfrastructureDeliveryMapper.class);

    Delivery toDomain(DeliveryEntity entity);

    DeliveryEntity toEntity(Delivery delivery);
}
