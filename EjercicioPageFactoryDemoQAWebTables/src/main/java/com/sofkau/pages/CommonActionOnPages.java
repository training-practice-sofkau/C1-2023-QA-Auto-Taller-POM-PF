package com.sofkau.pages;

import org.openqa.selenium.*;

import java.util.List;

public class CommonActionOnPages {
    private WebDriver driver;
    public CommonActionOnPages(WebDriver driver){
        this.driver=driver;
    }
    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void typeInto(WebElement webElement,String value){
        webElement.sendKeys(value);
    }
    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }
    protected void clearText(WebElement webElement){
        webElement.clear();
    }
    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void click(WebElement webElement){
        webElement.click();
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    protected void pressEnter(WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

    protected void pressSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }
    protected void pressSpace(WebElement webElement){
        webElement.sendKeys(Keys.SPACE);
    }
    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }

    protected  String getText (WebElement webElement){
        return webElement.getText();
    }
    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    public void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
