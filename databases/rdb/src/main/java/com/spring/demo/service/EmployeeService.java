package com.spring.demo.service;

import com.spring.demo.domains.employee.Employee;
import com.spring.demo.EmployeeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee findEmployee(Long id) {
        return employeeRepository.findEmployeeByOrThrow(id);
    }

    public boolean isEmployeeExist(Long id) {
        return employeeRepository.existsById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
