package com.snowshark.MagicPost.controllers;

import com.snowshark.MagicPost.entities.Staff;
import com.snowshark.MagicPost.services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffServices staffService;

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staff = staffService.getAllStaff();
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        Staff staff = staffService.getStaffById(id);
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/by-staff-id/{staffId}")
    public ResponseEntity<Staff> getStaffByStaffId(@PathVariable Long staffId) {
        Staff staff = staffService.getStaffByStaffId(staffId);
        return ResponseEntity.ok(staff);
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        Staff createdStaff = staffService.createStaff(staff);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStaff);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staff) {
        staff.setId(id); // Ensure ID is set for update
        Staff updatedStaff = staffService.updateStaff(staff);
        return ResponseEntity.ok(updatedStaff);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaffById(@PathVariable Long id) {
        staffService.deleteStaffById(id);
        return ResponseEntity.noContent().build();
    }
}