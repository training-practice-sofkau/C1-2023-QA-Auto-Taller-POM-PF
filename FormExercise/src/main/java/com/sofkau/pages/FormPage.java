package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends CommonActions {
    private final By name = By.id("firstName");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void fillMandatoryFields() {
        clearText(name);
        typeInto(name, "Juan");
    }
}
