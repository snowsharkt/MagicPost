package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "User")
@Table(
        name = "user"
//        uniqueConstraints = {
//                @UniqueConstraint(name = "", columnNames = "")
//        }

)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "user_id"
    )
    private Long userId;

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
}
