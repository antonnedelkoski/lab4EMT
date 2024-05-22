package com.example.lab4emt.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Status {

    private String value;

    // Constructors
    public Status() {
    }

    public Status(String value) {
        if (!isValidStatus(value)) {
            throw new IllegalArgumentException("Invalid status value");
        }
        this.value = value;
    }

    // Getters and Setters
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (!isValidStatus(value)) {
            throw new IllegalArgumentException("Invalid status value");
        }
        this.value = value;
    }

    private boolean isValidStatus(String value) {
        return value.equals("NEW") || value.equals("PROCESSING") || value.equals("COMPLETED") || value.equals("CANCELLED");
    }
}