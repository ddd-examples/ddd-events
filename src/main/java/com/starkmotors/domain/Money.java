package com.starkmotors.domain;

import java.util.Currency;
import java.util.Objects;

public class Money {
    private Float value;
    private Currency currency;

    public Money(Float value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Money indianRupees(Float value) {
        return new Money(value, Currency.getInstance("INR"));
    }

    public Money multiply(int multiplier) {
        return indianRupees(this.value * multiplier);
    }

    public Money add(Money toBeAdded) {
        return indianRupees(this.value + toBeAdded.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value) && Objects.equals(currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
