package com.sofkau.util;

import org.openqa.selenium.By;

public enum Localizador {
    FORM(By.xpath("(//div[@class='card-up'])[2]")),
    PRACTICE_FORM(By.xpath("(//span[text()='Practice Form'])")),
    NAME(By.id("firstName")),
    LASTNAME(By.id("lastName")),
    EMAIL(By.id("userEmail")),
    GENDER(By.xpath("(//label[@for='gender-radio-1'])")),
    NUMBER(By.id("userNumber")),
    DATE(By.id("dateOfBirthInput")),
    SUBJECT(By.id("subjectsInput")),
    HOBBIES(By.id("hobbies-checkbox-3")),
    CURRENT_ADDRESS(By.id("currentAddress")),
    STATE(By.id("react-select-3-input")),
    CITY(By.id("react-select-4-input")),
    SUBMIT(By.id("submit"));
    private final By by;
    Localizador(By by) {
        this.by = by;
    }
    public By getBy() {
        return by;
    }
}
