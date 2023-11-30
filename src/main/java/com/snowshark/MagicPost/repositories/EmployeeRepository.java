package com.snowshark.MagicPost.repositories;

import com.snowshark.MagicPost.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByUsername(String username);
}
