package com.spring.demo.handlers;

import com.spring.demo.domains.employee.Employee;
import com.spring.demo.domains.employee.EmployeeEmailUpdated;
import com.spring.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Log4j2
@AllArgsConstructor
@Component
public class EmployeeEmailUpdatedHandler implements EventHandlerChecker<EmployeeEmailUpdated> {

    private final EmployeeService employeeService;

    @EventListener(classes = {EmployeeEmailUpdated.class})
    public void handleEmailSentEvent(EmployeeEmailUpdated employeeEmailUpdated) {
        if (!isValid(employeeEmailUpdated)) {
            log.error("Employee with id " + employeeEmailUpdated.id() + " doesn't exist");
        }
        Employee employee = employeeService.findEmployee(employeeEmailUpdated.id());
        employee.setEmail(employee.getEmail());
        employeeService.saveEmployee(employee);
        log.error("Employee email is updated");
    }

    @Override
    public boolean isValid(EmployeeEmailUpdated event) {
        return employeeService.isEmployeeExist(event.id());
    }
}
