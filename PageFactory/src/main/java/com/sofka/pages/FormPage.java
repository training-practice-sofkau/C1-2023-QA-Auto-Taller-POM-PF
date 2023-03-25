package com.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage extends CommonActionOnPage{
    @CacheLookup
    @FindBy(xpath="//h5[normalize-space()='Elements']")
    private WebElement optionElements;

    @CacheLookup
    @FindBy(xpath="(//li[@id='item-3'])[1]")
    private WebElement optionWebTables;

    @CacheLookup
    @FindBy(id="addNewRecordButton")
    private WebElement buttonAdd;

    @CacheLookup
    @FindBy(id="firstName")
    private WebElement inputFirstName;

    @CacheLookup
    @FindBy(id="lastName")
    private WebElement inputLastName;

    @CacheLookup
    @FindBy(id="userEmail")
    private WebElement inputEmail;

    @CacheLookup
    @FindBy(id="age")
    private WebElement inputAge;

    @CacheLookup
    @FindBy(id="salary")
    private WebElement inputSalary;

    @CacheLookup
    @FindBy(id="department")
    private WebElement inputDepartment;

    @CacheLookup
    @FindBy(id="submit")
    private WebElement buttonSubmit;

    @CacheLookup
    @FindBy(xpath="(//div[@class='rt-td'])[22]")
    private WebElement nameTable;

    @CacheLookup
    @FindBy(xpath="(//div[@class='rt-td'])[24]")
    private WebElement ageTable;

    @CacheLookup
    @FindBy(xpath="(//div[@class='rt-td'])[25]")
    private WebElement emailTable;

    /**
     * Constructor
     * @param driver
     */
    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ingresoTabla(){
        clickElement(optionElements);
        clickElement(optionWebTables);
        clickElement(buttonAdd);
    }

    public void fillmandatoryFields(String nombre, String apellido, String edad, String correo, String salario, String departamento){
        clearText(inputFirstName);
        typeInto(inputFirstName, nombre);

        clearText(inputLastName);
        typeInto(inputLastName, apellido);

        clearText(inputEmail);
        typeInto(inputEmail, correo);

        clearText(inputAge);
        typeInto(inputAge, edad);

        clearText(inputSalary);
        typeInto(inputSalary, salario);

        clearText(inputDepartment);
        typeInto(inputDepartment, departamento);

        clickElement(buttonSubmit);
    }

    public WebElement getNameTable(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(nameTable));
    }

    public WebElement getAgeTable(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(ageTable));
    }

    public WebElement getEmailTable(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(emailTable));
    }
}
