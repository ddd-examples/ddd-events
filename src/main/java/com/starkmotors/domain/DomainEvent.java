package com.starkmotors.domain;

import java.time.LocalDate;

public interface DomainEvent {
    public LocalDate occurredOn();
}
