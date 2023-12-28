package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Shipment")
@Table(
        name = "shipment"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Shipment {
    @Id
    @Column(
            name = "id"
    )
    private String Id;


    @OneToMany(
            mappedBy = "shipment",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Order> orderList = new ArrayList<>();

    @Column(
            name = "address",
            nullable = false
    )
    private String address;

    @Column(
            name = "quantity",
            nullable = false
    )
    private Long quantity;

    @Column(
            name = "total_weight",
            nullable = false
    )
    private Long totalWeight;

}
