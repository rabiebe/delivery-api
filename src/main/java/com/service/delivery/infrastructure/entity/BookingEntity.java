package com.service.delivery.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryEntity delivery;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlotEntity timeSlot;

    private ZonedDateTime bookingDate;
}
