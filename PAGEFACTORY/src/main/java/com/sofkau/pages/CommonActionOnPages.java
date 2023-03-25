package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActionOnPages {
    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected  void typeInto(WebElement webElement, String value){

        webElement.sendKeys(value);
    }

    protected void clearText(By locator){

        driver.findElement(locator).clear();
    }

    protected void click(WebElement webElement) {
        webElement.click();
    }
    protected  String getText (WebElement webElement) {
        return webElement.getText();
    }
}
