package com.library.customizedenum;
import lombok.Getter;

@Getter
public enum RoleType {
    ADMIN("Admin"),
    LIBRARIAN("Librarian"),
    MEMBER("Member");

    private final String description;

    RoleType(String description) {
        this.description = description;
    }
}