package com.sofkau.util;

public enum Hobbies {
    SPORTS("Sports"),
    READING ("Reading"),
    MUSIC ("Music");

    private final String value;
    public String getValues(){return value; }
    Hobbies(String value){this.value = value;}
}
