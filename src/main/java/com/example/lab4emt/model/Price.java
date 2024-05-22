package com.example.lab4emt.model;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class Price {

    private BigDecimal amount;

    // Constructors
    public Price() {
    }

    public Price(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.amount = amount;
    }

    // Getters and Setters
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.amount = amount;
    }
}