package com.sofkau.pages.util;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String value;

    public String getValue() {
        return value;
    }
    Gender(String value) {
        this.value = value;
    }
}
