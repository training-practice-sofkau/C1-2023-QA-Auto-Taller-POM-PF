package com.sofkau.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class WebTablePage extends CommonActionOnPages {
    //Lista  que contiene los datos ingresados en el formulario
    public static List<String> datosIngresados = new ArrayList<>();

    //Lista que contiene los datos de la tabla
    public static List<String> datosTablaVisualizacion = new ArrayList<>();
    @CacheLookup
    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement iconoElement;
    @CacheLookup
    @FindBy(xpath = "//*[text()='Web Tables']")
    private WebElement iconoWebTablesRedireccion;
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement botonAgregarRegistro;
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
    private WebElement campoFirstName;

    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[339]")
    private WebElement campoLastName;

    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[340]")
    private WebElement campoAge;

    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[341]")
    private WebElement campoEmail;

    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[342]")
    private WebElement campoSalary;

    @CacheLookup
    @FindBy(xpath = "//div/descendant::*[343]")
    private WebElement campoDepartment;


    public WebTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigacionPaginaInicial() {
        scrollTo(iconoElement);
        click(iconoElement);
        scrollTo(iconoWebTablesRedireccion);
        click(iconoWebTablesRedireccion);
        scrollTo(botonAgregarRegistro);
        click(botonAgregarRegistro);
    }

    public void fillMandatoryFields(String nombre, String apellido, String edad, String correo, String salario, String departamento) {

        datosIngresados.clear();
        datosTablaVisualizacion.clear();
        typeInto(name, nombre);
        typeInto(lastName, apellido);
        typeInto(email, correo);
        typeInto(age, edad);
        typeInto(salary, salario);
        typeInto(department, departamento);
        click(submit);
        datosTablaWebResultantes();

    }

    public void datosTablaWebResultantes() {
        datosTablaVisualizacion.add (getText(campoFirstName));
        datosTablaVisualizacion.add (getText(campoLastName));
        datosTablaVisualizacion.add (getText(campoAge));
        datosTablaVisualizacion.add (getText(campoEmail));
        datosTablaVisualizacion.add (getText(campoSalary));
        datosTablaVisualizacion.add (getText(campoDepartment));

    }

    public void valorDatosIngresados(String nombre, String apellido, String edad, String correo, String salario, String departamento) {
        datosIngresados.add(nombre);
        datosIngresados.add(apellido);
        datosIngresados.add(edad);
        datosIngresados.add(correo);
        datosIngresados.add(salario);
        datosIngresados.add(departamento);
    }
}
