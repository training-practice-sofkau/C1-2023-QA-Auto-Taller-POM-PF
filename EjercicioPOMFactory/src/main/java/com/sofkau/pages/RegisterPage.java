package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.sikuli.script.Mouse.click;

public class RegisterPage extends CommonActionOnPages {



    @CacheLookup
    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement iconoElement;
    @CacheLookup
    @FindBy(xpath = "//*[text()='Web Tables']")
    private WebElement iconoWebTables;
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement iconoAdd;
    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement name;
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
    @FindBy(xpath = "//div/descendant::*[338]")
    private WebElement table_name;
    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[339]")
    private WebElement table_Lastname;
    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[340]")
    private WebElement table_age;
    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[341]")
    private WebElement table_email;
    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[342]")
    private WebElement table_salary;
    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[343]")
    private WebElement table_department;
    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void navigateToTablePage() {
        scrollTo(iconoElement);
        click(iconoElement);
        scrollTo(iconoWebTables);
        click(iconoWebTables);
        scrollTo(iconoAdd);
        click(iconoAdd);
    }

    public void fillMandatoryFields(String nombre, String apellido, String edad, String correo, String salario, String departamento) {

        typeInto(name, nombre);
        typeInto(lastName, apellido);
        typeInto(email, correo);
        typeInto(age, edad);
        typeInto(salary, salario);
        typeInto(department, departamento);
        click(submit);
    }

    public List<String> interfaceWebTable() {
        List<String> visualizationData = new ArrayList<>();
        visualizationData.add (getText(table_name));
        visualizationData.add (getText(table_Lastname));
        visualizationData.add (getText(table_age));
        visualizationData.add (getText(table_email));
        visualizationData.add (getText(table_salary));
        visualizationData.add (getText(table_department));
        return visualizationData;
    }
}
