package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum PaymentStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    REFUNDED("Refunded");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }
}