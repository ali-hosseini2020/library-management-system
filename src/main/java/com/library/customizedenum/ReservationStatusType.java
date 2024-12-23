package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum ReservationStatusType {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    EXPIRED("Expired");

    private final String description;

    ReservationStatusType(String description) {
        this.description = description;
    }
}