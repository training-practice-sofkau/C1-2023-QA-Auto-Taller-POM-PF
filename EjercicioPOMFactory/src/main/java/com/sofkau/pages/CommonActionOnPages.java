package com.sofkau.pages;

import org.openqa.selenium.*;

public class CommonActionOnPages {
    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void space(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void enter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void scrollTo(By locator){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }
    public void scrollTo(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }
    protected  String getText (By locator){
        return driver.findElement(locator).getText();
    }

    protected  String getText (WebElement webElement){
        return webElement.getText();
    }

    protected void setDate (By locator, String fecha) {
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), fecha, Keys.ENTER);
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }
    protected void click(WebElement webElement){
        webElement.click();
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void typeInto(WebElement webElement, String value){
        webElement.sendKeys(value);
    }
}
