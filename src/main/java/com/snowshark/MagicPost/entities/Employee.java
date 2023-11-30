package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Employee")
@Table(
        name = "employee"
//        uniqueConstraints = {
//                @UniqueConstraint(name = "", columnNames = "")
//        }

)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "employee_id"
    )
    private Long employeeId;

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
