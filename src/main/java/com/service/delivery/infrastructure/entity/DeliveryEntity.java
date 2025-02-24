package com.service.delivery.infrastructure.entity;

import com.service.delivery.domain.model.DeliveryMode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryEntity {


    @Id
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryMode mode;

    @Column(nullable = false)
    private Instant deliveryDate;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private Instant updatedAt;



    public DeliveryEntity(UUID id, DeliveryMode mode, Instant deliveryDate) {
        this.id = id;
        this.mode = mode;
        this.deliveryDate = deliveryDate;
    }


}



