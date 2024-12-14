package com.library.customizedenum;

import lombok.Getter;

@Getter
public enum MembershipType {
    REGULAR("Regular"),
    PREMIUM("Premium"),
    STUDENT("Student"),
    SENIOR("Senior");

    private final String description;

    MembershipType(String description) {
        this.description = description;
    }
}
