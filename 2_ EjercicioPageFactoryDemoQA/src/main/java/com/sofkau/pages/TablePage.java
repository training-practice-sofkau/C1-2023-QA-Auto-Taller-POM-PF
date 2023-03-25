package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TablePage extends CommonActionOnPages{

    private WebDriver webDriver;

    @CacheLookup
    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement elements;

    @CacheLookup
    @FindBy(xpath = "(//li[@class='btn btn-light '])[4]")
    private WebElement webTable;

    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement add;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "age")
    private WebElement age;

    @CacheLookup
    @FindBy(id = "salary")
    private WebElement salary;

    @CacheLookup
    @FindBy(id = "department")
    private WebElement department;

    @CacheLookup
    @FindBy(id = "submit")
    private WebElement submit;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='rt-td'])[22]")
    private WebElement finalName;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='rt-td'])[23]")
    private WebElement finalLastName;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='rt-td'])[24]")
    private WebElement finalAge;

    //Constructor
    public TablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegarTabla()  {
        clickElement(elements);
        clickElement(webTable);
    }

    public void fillMandatoryFields(String nombre, String apellido, String edad, String correo, String salario, String departamento) {
        clickElement(add);
        typeInto(firstName, nombre);
        typeInto(lastName, apellido);
        typeInto(age,edad);
        typeInto(email,correo);
        typeInto(salary,salario);
        typeInto(department,departamento);
        clickElement(submit);
    }

    public WebElement getNameFinal(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(finalName));
    }
    public WebElement getLastNameFinal(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(finalLastName));
    }
    public WebElement getAgeFinal(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(finalAge));
    }

}
