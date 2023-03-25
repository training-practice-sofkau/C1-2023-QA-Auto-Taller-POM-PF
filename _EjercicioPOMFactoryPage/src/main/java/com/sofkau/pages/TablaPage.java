package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class TablaPage extends CommonActionOnPages {
    public static List<String> informacion_ingresados=new ArrayList<>();
    public static List<String> informacion_table=new ArrayList<>();

    public TablaPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement iconoElement;
    @CacheLookup
    @FindBy(xpath = "//*[text()='Web Tables']")
    private WebElement botonWebTables;
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement botonagregar;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement nombre;
    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement apellido;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "age")
    private WebElement edad;
    @CacheLookup
    @FindBy(id = "salary")
    private WebElement salario;
    @CacheLookup
    @FindBy(id = "department")
    private WebElement department;

    @CacheLookup
    @FindBy(id = "submit")
    private WebElement submit;


    public void Inicio() throws InterruptedException{
        scroll(280);

        clickElement(iconoElement);

        clickElement(botonWebTables);
        //

    }
    public void  fillMandatoryFields(String nombre1, String apellido1, String edad1, String correo1, String salario1, String departamento1){
        informacion_ingresados.clear();
        informacion_table.clear();
        clickElement(botonagregar);
        typeInto(nombre,nombre1);
        typeInto(apellido,apellido1);
        typeInto(email,correo1);
        typeInto(edad,edad1);
        typeInto(salario,salario1);
       typeInto(department,departamento1);
        clickElement(submit);
        informacion_ingresados.add(nombre1);
        informacion_ingresados.add(apellido1);
        informacion_ingresados.add(edad1);
        informacion_ingresados.add(correo1);
        informacion_ingresados.add(salario1);
        informacion_ingresados.add(departamento1);
        informacion_table.add(getText(By.xpath("//div/descendant::*[338]")));
        informacion_table.add(getText(By.xpath("//div/descendant::*[339]")));
        informacion_table.add(getText(By.xpath("//div/descendant::*[340]")));
        informacion_table.add(getText(By.xpath("//div/descendant::*[341]")));
        informacion_table.add(getText(By.xpath("//div/descendant::*[342]")));
        informacion_table.add(getText(By.xpath("//div/descendant::*[343]")));

        System.out.println(informacion_ingresados);
        System.out.println(informacion_table);

    }

    }

