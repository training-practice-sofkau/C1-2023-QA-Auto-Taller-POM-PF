package com.sofkau.pages;

import org.openqa.selenium.*;

public class CommonActionOnPages {
    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(WebElement element, String value) { element.sendKeys(value); }

    protected void clearText(WebElement element) { element.clear(); }

    public void clickElement(WebElement element) {
        element.click();
    }

    protected void pressEnter(WebElement element) {element.sendKeys(Keys.ENTER); }

    protected void pressSpace(WebElement element) {element.sendKeys(Keys.SPACE); }

    public void scrollTo(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
