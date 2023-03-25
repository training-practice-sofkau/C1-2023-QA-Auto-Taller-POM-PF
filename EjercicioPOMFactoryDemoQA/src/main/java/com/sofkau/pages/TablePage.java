package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends CommonActionOnPages{
    public static List<String> datosIngresados=new ArrayList<>();
    public static List<String> datosTable=new ArrayList<>();
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
    public TablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void navigatePage(){
        click(iconoElement);
        click(iconoWebTables);
        click(iconoAdd);
    }

    public void fillMandatoryFields(String nombre, String apellido, String edad, String correo, String salario, String departamento){

        datosIngresados.clear();
        datosTable.clear();
        typeInto(name,nombre);
        typeInto(lastName,apellido);
        typeInto(email,correo);
        typeInto(age,edad);
        typeInto(salary,salario);
        typeInto(department,departamento);
        click(submit);
        datosIngresados.add(nombre);
        datosIngresados.add(apellido);
        datosIngresados.add(edad);
        datosIngresados.add(correo);
        datosIngresados.add(salario);
        datosIngresados.add(departamento);
        datosTable.add(getText(By.xpath("//div/descendant::*[338]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[339]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[340]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[341]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[342]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[343]")));
        System.out.println(datosIngresados);
        System.out.println(datosTable);

    }

    public void datosTabla(){
        datosTable.add(getText(By.xpath("//div/descendant::*[338]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[339]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[340]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[341]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[342]")));
        datosTable.add(getText(By.xpath("//div/descendant::*[343]")));
    }
}
