package com.sofka.pages;

import org.openqa.selenium.*;
import org.sikuli.script.Key;

public class CommonActionOnPage {

    WebDriver driver;

    public CommonActionOnPage(WebDriver driver) {
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

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);

    }

    protected void selectDate(By locator, String value) {
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);

    }

    protected void pressSpace(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Key.TAB);
    }
    protected void click (WebElement webElement){
        webElement.click();
    }
    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
