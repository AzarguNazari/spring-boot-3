package com.spring.demo.domains.employee;

import com.spring.demo.domains.DomainEvent;
import java.time.Instant;

public record EmployeeEmailUpdated(Long id, Email email, Instant occurredOn) implements DomainEvent {
    public EmployeeEmailUpdated {
        if (occurredOn == null) {
            occurredOn = Instant.now();
        }
    }

}
