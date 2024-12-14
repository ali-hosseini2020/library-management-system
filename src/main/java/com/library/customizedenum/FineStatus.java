package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum FineStatus {
    PENDING("Pending"),
    PAID("Paid"),
    OVERDUE("Overdue");

    private final String description;

    FineStatus(String description) {
        this.description = description;
    }
}