package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum PaymentStatusType {
    PENDING("Pending"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    REFUNDED("Refunded");

    private final String description;

    PaymentStatusType(String description) {
        this.description = description;
    }
}