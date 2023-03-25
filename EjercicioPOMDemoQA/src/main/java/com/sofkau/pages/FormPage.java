package com.sofkau.pages;

import com.sofkau.models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage extends CommonActionOnPages{
    private WebDriver driver;

    //private final Estudiante estudiante;


    //private final By inicio= By.xpath("(//div[@class='avatar mx-auto white'])[2])");
    //private final By inicio2= By.xpath("(//span[normalize-space()='Practice Form'])[1]");

    //casillas
    private final By name= By.id("firstName");
    private final By secondName= By.id("lastName");
    private final By email= By.id("userEmail");

    private final By gender= By.xpath("//label[@for='gender-radio-1']");
    private final By birth= By.id("dateOfBirthInput");

    private final By year= By.xpath("//option[@value='2002' or @value='2002']");
    private final By month= By.xpath("//option[@value='8' and text()='September']");
    private final By day= By.xpath("//div[@class='react-datepicker__day react-datepicker__day--014' and text()='14']");
    private final By mobile = By.id("userNumber");
    private final By hobbie= By.id("hobbies-checkbox-1");
    private final By addres= By.id("currentAddress");

    private final By subjects = By.id("subjectsInput");




    //funciones creadas
    public FormPage(WebDriver driver) {
        super(driver);
    }
    protected void selectDate(By locator, String value){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a"),value,Keys.ENTER);
    }



    public void fillMandatoryFields(){
        clearText(name);
        typeInto(name,"Bryan David");

        clearText(secondName);
        typeInto(secondName,"Polo");

        clearText(email);
        typeInto(email,"david2322@hotmail.com");


        click(gender);

        clearText(mobile);
        typeInto(mobile,"3105643785");

        /**click(birth);
         click(year);
         clearText(month);
         click(month);
         clearText(day);
         click(day);**/
        //selectDate(birth,"4 September 2002");

        clearText(subjects);
        typeInto(subjects,"Mathe");

        pressEnter(hobbie);

        clearText(addres);
        typeInto(addres,"cra46c 63-107");





    }

    /**public void inicioPagina() throws InterruptedException {
     click(inicio);
     Thread.sleep(2000);
     click(inicio2);
     }**/
}