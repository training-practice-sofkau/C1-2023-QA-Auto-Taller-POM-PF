package com.sofkau.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends CommonActionOnPages{

    //localizadores
    private final By form = By.xpath("(//div[@class='avatar mx-auto white'])[2]");
    private final By practiceForm = By.xpath("(//span[text()='Practice Form'])");

    private final By name = By.id("firstName");
    private final By lastname = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By gender = By.xpath("//label[@for='gender-radio-1']");
    private final By mobile = By.id("userNumber");
    private final By date = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");
    private final By hobbies = By.xpath("(//label[text()='Sports'])");

    //private final picture();
    private final By currentAddress = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By btnSubmit = By.id("submit");
    //constructor
    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void clickForm() throws InterruptedException {
        click(form);
        Thread.sleep(2000);
        click(practiceForm);

    }
    public void fillMandatoryFields(){
        clearText(name);
        typeInto(name, "James");
        typeInto(lastname, "Muñoz");
        typeInto(email, "jamb1993@gmail.com");
        click(gender);
        typeInto(mobile, "3148975672");
        selectDate(date, "20 august 2000");
        typeInto(subject, "Chemistry");
        tab(subject);
        click(hobbies);
        clearText(currentAddress);
        typeInto(currentAddress, "calle 34cc");
        typeInto(state, "NCR");
        pressEnter(state);
        typeInto(city, "Noida");
        pressEnter(city);
        pressSpace(btnSubmit);
    }
}
