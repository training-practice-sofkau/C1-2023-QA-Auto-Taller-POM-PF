package com.sofkau.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class CommonActionOnPage {
    protected WebDriver driver;
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
    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), value, Keys.ENTER);
    }
    protected void tab(By locator) {
        driver.findElement(locator).sendKeys(Keys.TAB);
    }
    protected void setZoom (int zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "%'");
    }
}
