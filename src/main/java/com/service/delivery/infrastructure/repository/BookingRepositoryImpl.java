package com.service.delivery.infrastructure.repository;

import com.service.delivery.application.ports.out.BookingRepository;
import com.service.delivery.domain.model.Booking;
import com.service.delivery.infrastructure.entity.BookingEntity;
import com.service.delivery.infrastructure.inframapper.InfrastructureBookingMapper;
import com.service.delivery.infrastructure.repository.jpa.JpaBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class BookingRepositoryImpl implements BookingRepository {

    private final JpaBookingRepository jpaBookingRepository;
    private final InfrastructureBookingMapper infrastructureBookingMapper;

    @Override
    public Booking save(Booking booking) {
        BookingEntity entity = infrastructureBookingMapper.toEntity(booking);
        return infrastructureBookingMapper.toDomain(jpaBookingRepository.save(entity));
    }

    @Override
    public Optional<Booking> findById(UUID id) {
        return jpaBookingRepository.findById(id).map(infrastructureBookingMapper::toDomain);
    }

    @Override
    public List<Booking> findAll() {
        return jpaBookingRepository.findAll().stream().map(infrastructureBookingMapper::toDomain).toList();
    }
}
