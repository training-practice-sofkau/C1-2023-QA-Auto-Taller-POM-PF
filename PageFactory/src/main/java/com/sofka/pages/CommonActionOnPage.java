package com.sofka.pages;

import org.openqa.selenium.*;

public class CommonActionOnPage {
    private WebDriver driver;

    public CommonActionOnPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    protected void typeInto(WebElement element, String value){
        element.sendKeys(value);
    }

    protected void clearText(WebElement element){
        element.clear();
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void pressSpace(WebElement element) {
        element.sendKeys(Keys.SPACE);
    }

    protected void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public void scrollTo(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
