package com.sofkau.pages;

import com.sofkau.model.Estudiante;
import org.openqa.selenium.*;

public class CommonActionOnPages {

    protected WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value){
        driver.findElement(locator).sendKeys(value);
    }

    protected void clearText(By locator){
        driver.findElement(locator).clear();
    }

    protected void click (By locator){
        driver.findElement(locator).click();
    }

    public void pressSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    public void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    protected void sendDate(By locator, String value){
    driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), "13 Mar 2003", Keys.ENTER);
    }
    protected void setZoom (int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }

}
