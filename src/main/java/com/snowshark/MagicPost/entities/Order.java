package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Order")
@Table(
    name = "order",
    uniqueConstraints = {
        @UniqueConstraint(name = "order_id_unique", columnNames = "id")
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
            name = "id"
    )
    private Long Id;

    @Column(
            name = "sender_name",
            nullable = false
    )
    private String sender_name;

    @Column(
            name = "sender_address",
            nullable = false
    )
    private String senderAddress;

    @Column(
            name = "sender_number",
            nullable = false
    )
    private String senderNumber;

    @Column(
            name = "reciever_name",
            nullable = false
    )
    private String recieverName;

    @Column(
            name = "reciever_address",
            nullable = false
    )
    private String recieverAddress;

    @Column(
            name = "reciever_number",
            nullable = false
    )
    private String recieverNumber;

    @Column(
            name = "type",
            nullable = false
    )
    private String type;

    @Column(
            name = "delivery_success",
            nullable = false
    )
    private String isDeliverySuccess;

    @Column(
            name = "weight",
            nullable = false
    )
    private Long weight;


    @ManyToOne
    @JoinColumn(
            name = "shipment_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "order_shipment_fk"
            )
    )
    private Shipment shipment;


}
