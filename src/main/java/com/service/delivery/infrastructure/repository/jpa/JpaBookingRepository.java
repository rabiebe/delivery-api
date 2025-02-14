package com.service.delivery.infrastructure.repository.jpa;

import com.service.delivery.infrastructure.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaBookingRepository extends JpaRepository<BookingEntity, UUID> {
}
