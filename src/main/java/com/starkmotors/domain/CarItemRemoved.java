package com.starkmotors.domain;

import java.time.LocalDate;

public class CarItemRemoved implements DomainEvent {

    private CartId cartId;
    private CartItem item;

    public CarItemRemoved(CartId cartId, CartItem item) {

        this.cartId = cartId;
        this.item = item;
    }

    @Override
    public LocalDate occurredOn() {
        return LocalDate.now();
    }
}
