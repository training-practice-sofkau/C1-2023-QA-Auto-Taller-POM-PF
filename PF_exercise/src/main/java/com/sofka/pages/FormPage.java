package com.sofka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FormPage extends CommonActionOnPage{
    public static ArrayList<String> esperado = new ArrayList<>();
    public static ArrayList<String> obtenido = new ArrayList<>();

            //localizadores

    @CacheLookup
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    private WebElement form;
    @CacheLookup
    @FindBy(xpath = "(//span[text()='Web Tables'])")
    private WebElement clickForm;
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement botonADD;

    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement nombre;

    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement apellido;

    @CacheLookup
    @FindBy(id = "age")
    private WebElement edad;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='userEmail'])[1]")
    private WebElement correo;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='salary'])[1]")
    private WebElement salario;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='department'])[1]")
    private WebElement departamento;

    @CacheLookup
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement botonSUBMIT;
    @CacheLookup
    @FindBy(xpath = "//div[normalize-space()='camila']")
    private WebElement ASNAME;
    @CacheLookup
    @FindBy(xpath = "(//div[@role='gridcell'])[28]")
    private WebElement ASSIMBOL;

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickForm() throws InterruptedException {
        scrollToElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]"));
        click( form);
        Thread.sleep(2000);
        scrollToElement(By.xpath("(//span[text()='Web Tables'])"));
        click( clickForm);
    }
    public void clickADD() {
        this.botonADD.click();
    }

    public void ingresoInformacion(String nombre, String apellido,  String correo,String edad, String salario, String departamento) {
        this.nombre.sendKeys(nombre);
        esperado.add(nombre);
        this.apellido.sendKeys(apellido);
        esperado.add(apellido);
        this.correo.sendKeys(correo);
        esperado.add(correo);
        this.edad.sendKeys(edad);
        esperado.add(edad);
        this.salario.sendKeys(salario);
        esperado.add(salario);
        this.departamento.sendKeys(departamento);
        esperado.add(departamento);
        click( botonSUBMIT);
        results();

    }
    public Set<String> results() {
        return IntStream.rangeClosed(22, 27)
                .mapToObj(i -> driver.findElement(By.xpath("(//div[@role='gridcell'])[" + i + "]")))
                .map(WebElement::getText)
                .peek(FormPage.obtenido::add)
                .collect(Collectors.toSet());
    }


}
