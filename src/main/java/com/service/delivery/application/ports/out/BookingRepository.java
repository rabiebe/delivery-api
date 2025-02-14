package com.service.delivery.application.ports.out;


import com.service.delivery.domain.model.Booking;
import com.service.delivery.infrastructure.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingRepository  {

    Booking save(Booking booking);
    Optional<Booking> findById(UUID id);
    List<Booking> findAll();
}
