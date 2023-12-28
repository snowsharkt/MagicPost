package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Staff")
@Table(
        name = "staff"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "collection_zipcode",
            nullable = false,
            referencedColumnName = "zipcode",
            foreignKey = @ForeignKey(
                    name = "collection_staff_fk"
            )
    )
    private Collection collection;

    @ManyToOne
    @JoinColumn(
            name = "transaction_zipcode",
            nullable = false,
            referencedColumnName = "zipcode",
            foreignKey = @ForeignKey(
                    name = "transaction_staff_fk"
            )
    )
    private Transaction transaction;

    @Column(
            name = "staff_id",
            nullable = false,
            unique = true
    )
    private Long staffId;

    @Column(
            name = "username"
    )
    private String username;

    @Column(
            name = "password"
    )
    private String password;

    @Column(
            name = "phone"
    )
    private String phone;


}
