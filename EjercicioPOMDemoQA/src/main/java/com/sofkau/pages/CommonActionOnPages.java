package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CommonActionOnPages {

    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver){
        this.driver=driver;
    }

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }
    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
}
