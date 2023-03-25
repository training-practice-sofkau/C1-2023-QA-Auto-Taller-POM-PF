package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class TablePage extends CommonActionOnPages{

    public static ArrayList<String> expected = new ArrayList<>();
    public static ArrayList<String> actual = new ArrayList<>();

    /**
     * Localizadores
     */
    @CacheLookup
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    private WebElement form;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Web Tables']")
    private WebElement webTable;

    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement addButton;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement userEmail;

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


    //Constructor
    public TablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickForm() throws InterruptedException {
        click(form);
        click(webTable);
    }


    public void fillMandatoryFields(String nombre, String apellido, String edad, String email, String salario, String departamento) {

        // asignación de los valores ingresados a variables locales
        String firstNameValue = nombre;
        String lastNameValue = apellido;
        String userEmailValue = email;
        String ageValue = edad;
        String salaryValue = salario;
        String departmentValue = departamento;

        // llenado de los campos del formulario
        click(addButton);
        typeInto(firstName, firstNameValue);
        expected.add(firstNameValue);
        typeInto(lastName, lastNameValue);
        expected.add(lastNameValue);
        typeInto(userEmail, userEmailValue);
        typeInto(age, ageValue);
        expected.add(ageValue);
        expected.add(userEmailValue);
        typeInto(salary, salaryValue);
        expected.add(salaryValue);
        typeInto(department, departmentValue);
        expected.add(departmentValue);
        click(submit);
        actuales();

    }

    public void actuales() {
        WebElement element;
        for (int i = 22; i <=27; i++) {
            element = driver.findElement(By.xpath("(//div[@class='rt-td'])[" +i+ "]"));
            actual.add(element.getText());
        }
    }

}
