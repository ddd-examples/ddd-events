package com.starkmotors.domain;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Cart {
    private CartId cartId;
    private List<CartItem> items = new ArrayList<>();
    private Money totalCost = new Money(0F, Currency.getInstance("INR"));

    private Cart(CartId cartId) {
        this.cartId = cartId;
    }

    public static Cart newCart() {
        return new Cart(CartId.newCarId());
    }

    private void updateTotal() {
        totalCost = items.stream()
                .map(CartItem::getSubTotal)
                .reduce(Money::add)
                .orElse(Money.indianRupees(0F));
    }

    public CartId getCartId() {
        return cartId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public void remove(AccessoryId accessoryId) {
        Optional<CartItem> toBeRemoved = items.stream().filter(i -> i.getAccessory().getAccessoryId().equals(accessoryId)).findAny();
        toBeRemoved.ifPresent(item -> {
            items.remove(item);
            updateTotal();
            DomainEventPublisher
                    .instance()
                    .publish(new CarItemRemoved(this.cartId, item));
        });

    }

    public void incrementQuantity(AccessoryId accessoryId) {
        items.stream()
                .filter(item -> item.getAccessory().getAccessoryId().equals(accessoryId))
                .findAny()
                .ifPresent(CartItem::incrementQuantity);
        updateTotal();
    }

    public void add(Accessory accessory, int quantity) {
        CartItem item = CartItem.forAccessory(accessory, quantity);
        items.add(item);
        updateTotal();
        DomainEventPublisher
                .instance()
                .publish(new CarItemAdded(this.cartId, item));
    }
}

class CartId {
    private UUID uuid;

    public CartId(UUID uuid) {
        this.uuid = uuid;
    }

    public static CartId newCarId() {
        return new CartId(UUID.randomUUID());
    }
}

class AccessoryId {
    private UUID uuid;

    public AccessoryId(UUID uuid) {
        this.uuid = uuid;
    }

    public static AccessoryId newAccessoryId() {
        return new AccessoryId(UUID.randomUUID());
    }
}
