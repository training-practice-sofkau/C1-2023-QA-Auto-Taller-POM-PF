package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Key;

public class CommonActionOnPages {

    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
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

    protected void space(By locator){
       driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void enter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Key.TAB);
    }

    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }


    public void setZoom(int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

}
