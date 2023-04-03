package com.sofkau.pages;

import org.openqa.selenium.*;

public class CommonActionOnPages {
    WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    public void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    public void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void pressEnter(By locator) {

        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    protected void click (WebElement webElement){
        webElement.click();
}
    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
}
}