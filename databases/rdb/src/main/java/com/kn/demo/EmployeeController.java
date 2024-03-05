package com.kn.demo;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@AllArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping("/api/employees")
    public void receiveEmployee(@RequestBody EmployeeEmailUpdated employeeEmailUpdated) {
       log.error(employeeEmailUpdated);
    }

}
