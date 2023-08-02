package com.starkmotors.domain;

public interface DomainEventSubscriber {

    public void handle(DomainEvent domainEvent);

    boolean isSubscribedTo(Class<? extends DomainEvent> aClass);
}
