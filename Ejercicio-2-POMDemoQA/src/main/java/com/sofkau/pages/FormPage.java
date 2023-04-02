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
    private WebElement BOTON_ELEMENT;

    @CacheLookup
    @FindBy (xpath = "(//li[@id= 'item-3'])[1]")
    private WebElement BOTON_WEBTABLE;

    @CacheLookup
    @FindBy (id = "addNewRecordButton")
    private WebElement BOTON_ADD;
    @CacheLookup
    @FindBy (id = "firstName")
    private WebElement CAJON_FIRST_NAME;
    @CacheLookup
    @FindBy (id = "lastName")
    private WebElement CAJON_LAST_NAME;
    @CacheLookup
    @FindBy (id = "userEmail")
    private WebElement CAJON_EMAIL;
    @CacheLookup
    @FindBy (id = "age")
    private WebElement CAJON_AGE;
    @CacheLookup
    @FindBy (id = "salary")
    private WebElement CAJON_SALARY;
    @CacheLookup
    @FindBy (id = "department")
    private WebElement CAJON_DEPARTMENT;
    @CacheLookup
    @FindBy (id = "submit")
    private WebElement CAJON_SUBMIT;


    public FormPage(WebDriver driver) {
        super(driver);
    }
}