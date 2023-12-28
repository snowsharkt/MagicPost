package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Transaction")
@Table(
        name = "transaction"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
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

    @ManyToOne
    @JoinColumn(
            name = "collection_zipcode",
            nullable = false,
            referencedColumnName = "zipcode",
            foreignKey = @ForeignKey(
                    name = "collection_transaction_fk"
            )
    )
    private Collection collection;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "transaction"
    )
    private List<Staff> staffList = new ArrayList<>();

    @Column(
            name = "zipcode"
    )
    private String zipcode;

    @Column(
            name = "username"
    )
    private String username;

    @Column(
            name = "password"
    )
    private String password;

    @Column(
            name = "name"
    )
    private String name;


    @Column(
            name = "address"
    )
    private String address;

}
