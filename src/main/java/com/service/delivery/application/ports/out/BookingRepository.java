package com.service.delivery.application.ports.out;


import com.service.delivery.infrastructure.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BookingRepository extends JpaRepository<BookingEntity, UUID> {

}
