package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Admin")
@Table(
        name = "admin"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "role"
    )
    private String role;

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
