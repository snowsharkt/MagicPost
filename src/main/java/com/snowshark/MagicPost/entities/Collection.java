package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Collection")
@Table(
        name = "collection"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "admin_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "admin_id_fk"
            )
    )
    private Admin admin;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "collection"
    )
    private List<Staff> staffList = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "collection"
    )
    private List<Transaction> transactionList = new ArrayList<>();

    @Column(
            name = "zipcode"
    )
    private String zipcode;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;


    @Column(
            name = "address",
            nullable = false
    )
    private String address;


}
