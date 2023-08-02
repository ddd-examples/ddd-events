package com.starkmotors.domain;

import java.time.LocalDate;

public class CarItemAdded implements DomainEvent {

    private CartId cartId;
    private CartItem item;

    public CarItemAdded(CartId cartId, CartItem item) {

        this.cartId = cartId;
        this.item = item;
    }

    @Override
    public LocalDate occurredOn() {
        return null;
    }
}
