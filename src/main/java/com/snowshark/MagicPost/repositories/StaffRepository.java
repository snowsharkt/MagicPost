package com.snowshark.MagicPost.repositories;

import com.snowshark.MagicPost.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByStaffId(Long staffId);
}
