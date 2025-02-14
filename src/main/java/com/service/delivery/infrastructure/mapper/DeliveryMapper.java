package com.service.delivery.infrastructure.mapper;

import com.service.delivery.domain.model.Delivery;
import com.service.delivery.infrastructure.entity.DeliveryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryMapper INSTANCE = Mappers.getMapper(DeliveryMapper.class);

    Delivery toDomain(DeliveryEntity entity);

    DeliveryEntity toEntity(Delivery delivery);
}
