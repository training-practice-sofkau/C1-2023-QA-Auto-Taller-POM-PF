package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

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

    protected void setDate (By locator, String fecha) {
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), fecha, Keys.ENTER);
    }

    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

//    protected void pressEnter(By locator) {
//        driver.findElement(locator).sendKeys(Keys.ENTER);
//    }
}
