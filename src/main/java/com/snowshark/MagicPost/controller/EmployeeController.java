package com.snowshark.MagicPost.controller;

import com.snowshark.MagicPost.entities.Employee;
import com.snowshark.MagicPost.errors.EmployeeNotFoundException;
import com.snowshark.MagicPost.services.EmployeeServices;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @PostMapping("/")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) throws Exception {
        return employeeServices.saveEmployee(employee);
    }

    @GetMapping("/")
    public List<Employee> fetchEmployeeList() {
        return employeeServices.fetchEmployeeList();
    }

    @GetMapping("/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeNotFoundException {
        return employeeServices.fetchEmployeeById(employeeId);

    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) {
        employeeServices.deleteEmployeeById(employeeId);
        return "Deleted Successful!";
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") Long employeeId,
                                       @Valid @RequestBody Employee employee) throws Exception {
        return employeeServices.updateEmployee(employeeId, employee);
    }

}
