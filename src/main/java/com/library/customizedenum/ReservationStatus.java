package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum ReservationStatus {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    EXPIRED("Expired");

    private final String description;

    ReservationStatus(String description) {
        this.description = description;
    }
}