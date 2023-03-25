package com.sofkau.util;

public enum Hobbie {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private final String value;

    public String getValue(){
        return value;
    }

    Hobbie(String value) {
        this.value = value;
    }
}
