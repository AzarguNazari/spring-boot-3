package com.kn.demo;

import static java.lang.String.format;
import org.springframework.data.repository.ListCrudRepository;

public interface EmployeeRepository extends ListCrudRepository<Employee, Long> {

    default Employee findEmployeeByOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new EmployeeNotFoundException(format("Employee with id (%d) is not found", id)));
    }

}
