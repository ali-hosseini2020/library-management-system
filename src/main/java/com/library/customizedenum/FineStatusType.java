package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum FineStatusType {
    PENDING("Pending"),
    PAID("Paid"),
    OVERDUE("Overdue");

    private final String description;

    FineStatusType(String description) {
        this.description = description;
    }
}