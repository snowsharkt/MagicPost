package com.snowshark.MagicPost.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Employee")
@Table(
        name = "employee"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
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

    @Column(
            name = "full_name"
    )
    private String fullName;

    @Column(
            name = "gender"
    )
    private String gender;

    @Column(
            name = "work_area_id"
    )
    private Long workAreaId;

    @Column(
            name = "leader_id"
    )
    private Long leaderId;
}
