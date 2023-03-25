package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends CommonActionOnPages {

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // localizadores
    @CacheLookup
    @FindBy(id="addNewRecordButton")
    private WebElement addNewRecordButton;

    @CacheLookup
    @FindBy(id="firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id="lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id="userEmail")
    private WebElement email;

    @CacheLookup
    @FindBy(id="age")
    private WebElement age;

    @CacheLookup
    @FindBy(id="salary")
    private WebElement salary;

    @CacheLookup
    @FindBy(id="department")
    private WebElement department;

    @CacheLookup
    @FindBy(id="submit")
    private WebElement submit;

    @CacheLookup
    @FindBy(xpath = "//div[@class='rt-tbody']/child::div[position()=4]/child::div/child::div[position()=1]")
    private WebElement name;

    @CacheLookup
    @FindBy(xpath = "//div[@class='rt-tbody']/child::div[position()=4]/child::div/child::div[position()=4]")
    private WebElement confirmEmail;

    private final By form = By.xpath("//*[contains(text(), 'Forms')]");
    private final By elements = By.xpath("//*[contains(text(),'Elements')]");
    private final By webTables = By.xpath("//*[@class='text' and text()='Web Tables']");

    public void fillMandatoryFields(String nombre, String apellido, String edad, String correo, String salario, String departamento){

        click(addNewRecordButton);
        typeInto(firstName, nombre);
        typeInto(lastName, apellido);
        typeInto(age, edad);
        typeInto(email, correo);
        typeInto(salary, salario);
        typeInto(department, departamento);
        click(submit);
    }

    public String getName(){
        return getText(name);
    }

    public String getEmail(){
        return getText(confirmEmail);
    }


}
