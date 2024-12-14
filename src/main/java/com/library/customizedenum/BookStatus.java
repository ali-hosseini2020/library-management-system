package com.library.customizedenum;

import lombok.Getter;
@Getter
public enum BookStatus {
    AVAILABLE("Available"),
    CHECKED_OUT("Checked Out"),
    RESERVED("Reserved"),
    LOST("Lost"),
    DAMAGED("Damaged");

    private final String description;

    BookStatus(String description) {
        this.description = description;
    }
}




















/*
import lombok.RequiredArgsConstructor;
import lombok.Getter;
@Getter
@RequiredArgsConstructor

public enum BookStatus {
    AVAILABLE("Book Available"),
    BORROWED("Book Borrowed"),
    RESERVED("Book Reserved"),
    LOST("Book Lost"),
    DAMAGED("Book Damaged");

    private final String description;
}*/
