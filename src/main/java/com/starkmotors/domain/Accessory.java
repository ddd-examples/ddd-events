package com.starkmotors.domain;

public class Accessory {
    private AccessoryId accessoryId;
    private AccessoryName name;
    private Money cost;

    public Accessory(AccessoryId accessoryId, AccessoryName name, Money cost) {
        this.accessoryId = accessoryId;
        this.name = name;
        this.cost = cost;
    }

    public static Accessory newAccessory(AccessoryName name, Money cost) {
        return new Accessory(AccessoryId.newAccessoryId(), name, cost);
    }

    public AccessoryId getAccessoryId() {
        return accessoryId;
    }

    public AccessoryName getName() {
        return name;
    }

    public Money getCost() {
        return cost;
    }
}
