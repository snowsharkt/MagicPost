package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity(name = "Order")
@Table(
    name = "order_details",
    uniqueConstraints = {
        @UniqueConstraint(name = "order_code_unique", columnNames = "order_code")
    }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Order {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "order_id"
    )
    private Long orderId;

    @Column(
            name = "order_code",
            nullable = false
    )
    private String orderCode;

    @Column(
            name = "send_address",
            nullable = false
    )
    private String sendAddress;

    @Column(
            name = "recieve_address",
            nullable = false
    )
    private String recieveAddress;

    @Column(
            name = "processing",
            nullable = false
    )
    private boolean isProcessing;

    @Column(
            name = "delivery_success",
            nullable = false
    )
    private String isDeliverySuccess;

    @Column(
            name = "arrived_time",
            nullable = false
    )
    private LocalDateTime arrivedTime;

    @Column(
            name = "paid",
            nullable = false
    )
    private boolean isPaid;

}
