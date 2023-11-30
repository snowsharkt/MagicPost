package com.snowshark.MagicPost.services;

import com.snowshark.MagicPost.entities.Employee;
import com.snowshark.MagicPost.errors.EmployeeNotFoundException;
import com.snowshark.MagicPost.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServicesImplement implements EmployeeServices{

    private final EmployeeRepository employeeRepository;


    public EmployeeServicesImplement(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee saveEmployee(Employee employee) throws Exception {
        if (employeeRepository.existsByUsername(employee.getUsername()))
            throw new Exception("Username existed!");
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public  Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("No employee with this Id found!");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) throws Exception {
        Optional<Employee> findEmployee = employeeRepository.findById(employeeId);
        if (findEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("No employee with this Id found!");
        }
        Employee employeeDB = findEmployee.get();

        if (employeeRepository.existsByUsername(employee.getUsername()))
            throw new Exception("Username existed!");
        if (Objects.nonNull(employeeDB.getUsername())
            && !employeeDB.getUsername().isEmpty()) {
            employeeDB.setUsername(employee.getUsername());
        }

        if (Objects.nonNull(employeeDB.getPassword())
                && !employeeDB.getPassword().isEmpty()) {
            employeeDB.setUsername(employee.getPassword());
        }

        return employeeRepository.save(employeeDB);
    }
}
