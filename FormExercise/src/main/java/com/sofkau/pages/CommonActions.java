package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonActions {
    private WebDriver driver;

    public CommonActions(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
}
