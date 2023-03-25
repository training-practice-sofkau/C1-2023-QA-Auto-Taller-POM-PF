package com.sofkau.pages;

import com.sofkau.models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FormPage extends CommonActionOnPages{

    @CacheLookup
    @FindBy (xpath = "(//div[contains(@class, 'card nt-4 top-card')])[1]")
    private WebElement botonElement;

    @CacheLookup
    @FindBy (xpath = "(//li[@id= 'item-3'])[1]")
    private WebElement botonWebTable;


    public FormPage(WebDriver driver) {
        super(driver);
    }
}