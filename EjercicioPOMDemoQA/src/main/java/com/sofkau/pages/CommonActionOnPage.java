package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonActionOnPage {
    private WebDriver driver;

    public CommonActionOnPage(WebDriver driver) {
        this.driver = driver;
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

    protected void pressSpace(By locator) {
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void selectAllText(By locator){
        WebElement input = driver.findElement(locator);
        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL,"a"));
    }

    protected void pressEnter(By locator) {
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressEscape(By locator){
        driver.findElement(locator).sendKeys(Keys.ESCAPE);
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
}
