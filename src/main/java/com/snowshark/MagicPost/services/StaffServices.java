package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Staff;

import java.util.List;

public interface StaffServices {

    List<Staff> getAllStaff();

    Staff getStaffById(Long id);

    Staff getStaffByStaffId(Long staffId);

    Staff createStaff(Staff staff);

    Staff updateStaff(Staff staff);

    void deleteStaffById(Long id);
}
