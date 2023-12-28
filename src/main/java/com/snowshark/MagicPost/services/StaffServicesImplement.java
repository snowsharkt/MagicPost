package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Staff;
import com.snowshark.MagicPost.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServicesImplement implements StaffServices {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }

    @Override
    public Staff getStaffByStaffId(Long staffId) {
        return staffRepository.findByStaffId(staffId);
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaffById(Long id) {
        staffRepository.deleteById(id);
    }
}
