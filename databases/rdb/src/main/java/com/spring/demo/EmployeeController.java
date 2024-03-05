package com.spring.demo;

import com.spring.demo.domains.employee.EmployeeEmailUpdated;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@AllArgsConstructor
@RestController
public class EmployeeController {

    private final ApplicationEventPublisher eventPublisher;

    @PostMapping("/api/employees")
    public void receiveEmployee(@RequestBody EmployeeEmailUpdated employeeEmailUpdated) {
       eventPublisher.publishEvent(employeeEmailUpdated);
    }

}
