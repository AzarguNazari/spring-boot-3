package com.spring.demo;

import com.spring.demo.domains.employee.Employee;
import com.spring.demo.service.EmployeeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Log4j2
@SpringBootApplication
public class RdbApp {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(RdbApp.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return (args) -> {
			employeeService.saveEmployee(Employee.builder()
					.id(1234L)
					.email("something@something.com")
				.build());
			log.error(employeeService.findAllEmployees());
		};
	}

}
