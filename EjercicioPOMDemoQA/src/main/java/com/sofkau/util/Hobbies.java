package com.sofkau.util;

public enum Hobbies {
    HOBBIE1("Sports"),
    HOBBIE2("Reading"),
    HOBBIE3("Music");

    private final String value;

    public String getValue() {
        return value;
    }

    Hobbies(String value) {
        this.value = value;
    }
}
