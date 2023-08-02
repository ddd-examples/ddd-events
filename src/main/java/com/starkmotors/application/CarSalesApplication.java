package com.starkmotors.application;

import com.starkmotors.domain.Accessory;
import com.starkmotors.domain.AccessoryName;
import com.starkmotors.domain.Cart;
import com.starkmotors.domain.CartItemAddedSubscriber;
import com.starkmotors.domain.CartItemRemovedSubscriber;
import com.starkmotors.domain.DomainEventPublisher;
import com.starkmotors.domain.Money;

public class CarSalesApplication {

    public static void main(String[] args) {
        Cart cart = Cart.newCart();
        Accessory seatCover = Accessory.newAccessory(new AccessoryName("Seat Cover"), Money.indianRupees(1000.00F));
        Accessory alloyWheels = Accessory.newAccessory(new AccessoryName("Alloy Wheel"), Money.indianRupees(2000.00F));
        //transaction start
        DomainEventPublisher.instance()
                        .subscribe(new CartItemAddedSubscriber());
        DomainEventPublisher.instance()
                        .subscribe(new CartItemRemovedSubscriber());
        cart.add(seatCover, 1);
        System.out.println(cart.getTotalCost());

        cart.remove(seatCover.getAccessoryId());
        System.out.println(cart.getTotalCost());

        cart.add(alloyWheels, 4);
        System.out.println(cart.getTotalCost());

        cart.incrementQuantity(alloyWheels.getAccessoryId());
        System.out.println(cart.getTotalCost());

        //save cart
        //transaction ends
    }

}
