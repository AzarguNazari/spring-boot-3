package com.kn.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee findEmployee(Long id) {
        return employeeRepository.findEmployeeByOrThrow(id);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
