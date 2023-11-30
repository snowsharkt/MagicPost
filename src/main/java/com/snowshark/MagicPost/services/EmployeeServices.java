package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Employee;
import com.snowshark.MagicPost.errors.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeServices {
    public Employee saveEmployee(Employee employee) throws Exception;
    public List<Employee> fetchEmployeeList();
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;
    public void deleteEmployeeById(Long employeeId);
    public Employee updateEmployee(Long employeeId, Employee employee) throws Exception;
}
