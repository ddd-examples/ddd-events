package com.starkmotors.domain;

public class CartItemAddedSubscriber implements DomainEventSubscriber{
    @Override
    public void handle(DomainEvent domainEvent) {
        //publish to message broker
    }

    @Override
    public boolean isSubscribedTo(Class<? extends DomainEvent> aClass) {
        return aClass == CarItemAdded.class;
    }
}
