package com.sofkau.pages;

import org.openqa.selenium.*;


public class CommonActionOnPages {

    private WebDriver driver;

    public CommonActionOnPages(WebDriver driver) {
        this.driver = driver;
    }

    protected void typeInto(By locator, String value){

        driver.findElement(locator).sendKeys(value);
    }

    protected  void typeInto(WebElement webElement, String value){
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

    protected void pressSpace(By locator){
        driver.findElement(locator).sendKeys(Keys.SPACE);
    }

    protected void pressSpace(WebElement webElement){
        webElement.sendKeys(Keys.SPACE);
    }

    protected void pressEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected String getText(WebElement webElement){
        return webElement.getText();
    }

    public void clickForm(By locator) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", driver.findElement(locator));
    }

}
