package com.starkmotors.domain;

public class CartItem {
    private Accessory accessory;
    private Integer quantity;

    private Money subTotal;

    public CartItem(Accessory accessory, Integer quantity, Money subTotal) {
        this.accessory = accessory;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public static CartItem forAccessory(Accessory accessory, Integer quantity) {
        return new CartItem(accessory, quantity, accessory.getCost().multiply(quantity));
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public void incrementQuantity() {
        quantity += 1;
        updateSubTotal();
    }

    private void updateSubTotal() {
        subTotal = accessory.getCost().multiply(quantity);
    }
}
