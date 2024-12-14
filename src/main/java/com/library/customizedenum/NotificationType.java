package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum NotificationType {
    EMAIL("Email"),
    SMS("SMS"),
    PUSH_NOTIFICATION("Push Notification");

    private final String description;

    NotificationType(String description) {
        this.description = description;
    }
}