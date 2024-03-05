package com.spring.demo.domains;

import java.time.Instant;

public interface DomainEvent {
    Instant occurredOn();
}
