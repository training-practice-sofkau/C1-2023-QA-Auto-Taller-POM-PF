package com.sofkau.pages;

import com.sofkau.models.Empleado;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TableRegPage extends CommonActionsOnPages{
    @CacheLookup
    @FindBy(xpath = "(//div[contains(@class, 'card mt-4 top-card')])[1]")
    private WebElement botonElement;

    @CacheLookup
    @FindBy(xpath = "(//li[@id='item-3'])[1]")
    private WebElement botonWebTable;

    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement botonAddRecord;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement fieldFirstName;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement fieldLastName;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement fieldEmail;

    @CacheLookup
    @FindBy(id = "age")
    private WebElement fieldAge;

    @CacheLookup
    @FindBy(id = "salary")
    private WebElement fieldSalary;

    @CacheLookup
    @FindBy(id = "department")
    private WebElement fieldDepartment;

    @CacheLookup
    @FindBy(id = "submit")
    private WebElement btnSubmit;

    @CacheLookup
    @FindBy(xpath = "(//div[@role='row'])[5]")
    private WebElement fila5;

    private By celdas = By.xpath(".//div[@role='gridcell']");

    public TableRegPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToTable(){
        click(botonElement);
        click(botonWebTable);
    }

    public void startNewRecord(){
        setZoom(80);
        pressEnter(botonAddRecord);
    }

    public void fillMandatory(String firstname, String lastname,
                              String email, String age, String salary,
                              String department){
        typeInto(fieldFirstName, firstname);
        typeInto(fieldLastName, lastname);
        typeInto(fieldEmail, email);
        typeInto(fieldAge, age);
        typeInto(fieldSalary, salary);
        typeInto(fieldDepartment, department);
        pressEnter(btnSubmit);
    }

    public String[] getDataFromTable(){
        WebElement fila = fila5;
        List<WebElement> campos = fila.findElements(celdas);
        String[] valores = new String[campos.size()-1];
        for (int i = 0; i < campos.size()-1; i++) {
            valores[i] = campos.get(i).getText();
        }
        return valores;
    }
}
