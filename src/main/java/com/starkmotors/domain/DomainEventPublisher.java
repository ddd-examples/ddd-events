package com.starkmotors.domain;


import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {

    private static ThreadLocal<DomainEventPublisher> instance = ThreadLocal.withInitial(DomainEventPublisher::new);

    private List<DomainEventSubscriber> subscribers = new ArrayList();

    public static DomainEventPublisher instance() {
        return instance.get();
    }

    public void publish(DomainEvent domainEvent) {
        subscribers.stream()
                .filter(subscriber -> subscriber.isSubscribedTo(domainEvent.getClass()))
                .forEach(subscriber -> subscriber.handle(domainEvent));
    }

    public void subscribe(DomainEventSubscriber subscriber) {
        subscribers.add(subscriber);
    }
}
