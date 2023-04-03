package com.sofkau.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends CommonActionOnPages{

    private WebDriver driver;
    private final By name= By.id("firstName");
    private final By secondName= By.id("lastName");
    private final By email= By.id("userEmail");
    private final By gender= By.xpath("//label[@for='gender-radio-1']");
    private final By birth= By.id("dateOfBirthInput");
    private final By year= By.xpath("//option[@value='1996']");
    private final By month= By.xpath("//option[@value='10']");
    private final By day= By.xpath("//div[@aria-label='Choose Wednesday, November 20th, 1996']");
    private final By mobile = By.id("userNumber");
    private final By hobbie= By.xpath("//label[normalize-space()='Reading']");
    private final By addres= By.id("currentAddress");
    private final By subjects = By.id("subjectsInput");

    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");

    private final By MENSAJE_ASERCION = By.xpath("//div[@id='example-modal-sizes-title-lg']");

    public FormPage(WebDriver driver) {
        super(driver);
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
        click(birth);
        click(year);
        click(month);
        click(day);
        typeInto(subjects,"Computer Science");
        pressEnter(subjects);
        scroll(state);
        click(hobbie);
        clearText(addres);
        typeInto(addres,"cra46c 63-107");
        scroll(state);
        typeInto(state,"Haryana");
        pressEnter(state);
        typeInto(city,"Karnal");
        pressEnter(city);
        pressEnter(city);


    }
}