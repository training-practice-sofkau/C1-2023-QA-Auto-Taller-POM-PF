package com.sofkau.pages;

import com.sofkau.util.Estudiante;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage extends  CommonActionOnPages{
    private static final int TEN_SECONS = 10;
    Estudiante estudiante = new Estudiante("Efrain",
            "Solorzano",
            "efsolora@gmail.com",
            "3243242342342432",
            "12/12/2023",
            "maths",
            "cr50",
            "ncr",
            "delhi");


    private  static final By form = By.xpath("//*[@class='card mt-4 top-card'][6]");
    private  static final By clikForm =  By.xpath("(//*[@class='group-header'])[2]");
    private  static final By practiceForm =  By.xpath("//div[@class='element-list collapse show']");
    private static final By name = By.id("firstName");
    private static final By lastName = By.id("lastName");
    private static final By email = By.id("userEmail");
    private static final By gender  = By.xpath("//*[@class='custom-control custom-radio custom-control-inline'][1]");
    private static final By mobile = By.id("userNumber");
    private static final By date = By.id("dateOfBirthInput");
    private static final By subject =  By.id("subjectsInput");
    private static final By hobbies = By.xpath("//*[@class='custom-control custom-checkbox custom-control-inline'][1]");
    private static final By address = By.id("currentAddress");
    private static final By state = By.id("react-select-3-input");
    private static final By city = By.id("react-select-4-input");
    private static final By submit = By.id("submit");
    private static final By scrollForm = By.xpath("//*[contains(text(),'TravelTip')]");
    private static final  By assertName = By.xpath("//td[2]");
    private static final By assertEmail = By.xpath("(//td)[4]");
    private static final By assertPhone = By.xpath("(//td)[8]");
    private static final By assertAddress = By.xpath("(//td)[18]");



    public FormPage(WebDriver driver) {
        super(driver);

    }

    public void practiceForm() throws InterruptedException {
        Thread.sleep(10000);
        scrollTo(form);
        click(form);
        click(clikForm);
        click(practiceForm);
    };


    public void fillMandatoryFields() {

        scrollTo(submit);
        typeInto(name,estudiante.getNombre());
        typeInto(lastName,estudiante.getApellido());
        typeInto(email,estudiante.getEmail());
        click(gender);
        typeInto(mobile,estudiante.getCelular());
        clearText(date);
        typeInto(date,estudiante.getFechaNacimienti());
        enter(date);
        typeInto(subject,estudiante.getMateria());
        enter(subject);
        click(hobbies);
        typeInto(address,estudiante.getDireccion());
        setZoom(50);
        typeInto(state,estudiante.getEstado());
        enter(state);
        typeInto(city,estudiante.getCiudad());
        enter(city);
        tab(city);
        enter(submit);

    }

    public String assertionName(){
        String ass = getText(assertName);
        return ass;
    }
    public String assertionEmail(){
        String ass = getText(assertEmail);
        return ass;
    }
    public String assertionPhone(){
        String ass = getText(assertPhone);
        return ass;
    }

    public String assertionAddres(){
        String ass = getText(assertAddress);
        return ass;
    }
}
