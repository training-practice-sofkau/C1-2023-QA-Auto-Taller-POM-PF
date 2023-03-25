package com.sofkau.pages;
import com.sofkau.models.Estudiante;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static com.sofkau.util.Gender.*;

public class FormPage extends CommonActionOnPages{
    private WebDriver driver;
    private Estudiante e= new Estudiante();

    //localizadores

    private final By name= By.id("firstName");
    private final By secondName= By.id("lastName");
    private final By email= By.id("userEmail");
    private final By genderMale = By.xpath("//label[normalize-space()='Male']");
    private final By genderFemale = By.xpath("//label[normalize-space()='Female']");
    private final By genderOther = By.xpath("//label[normalize-space()='Other']");
    private final By mobile = By.id("userNumber");
    private final By date = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");
    private final By hobbieone = By.id("hobbies-checkbox-1");
    private final By hobbietwo = By.id("hobbies-checkbox-2");
    private final By hobbiethree = By.id("hobbies-checkbox-3");

    private final By addres= By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By btnSubmit = By.id("submit");





    //funciones creadas
    public FormPage(WebDriver driver,Estudiante e) {
        super(driver);
        this.e=e;
    }

    /**public void clickForm() throws InterruptedException {
        click(form);
        Thread.sleep(2000);
        click(practiceForm);

    }**/



    public void fillMandatoryFields(){
    clearText(name);

    typeInto(name,e.getName());

    typeInto(secondName,e.getSecondname());

    typeInto(email,e.getEmail());

    switch (e.getGender()) {
            case FEMALE:
                click(genderFemale);
                break;
                case MALE:
                click(genderMale);
                break;
            case OTHER:
                click(genderOther);
                break;
            default:
    }

    clearText(mobile);

    typeInto(mobile,e.getMobile());

    selectDate(date, e.getDate());


    typeInto(subject,e.getSubject());
    tab(subject);

    pressSpace(hobbieone);
    pressSpace(hobbietwo);
    pressSpace(hobbiethree);

    clearText(addres);
    typeInto(addres,e.getCurrentAddres());

    typeInto(state, e.getState());
    pressEnter(state);

    typeInto(city, e.getCity());
    pressEnter(city);

    pressSpace(btnSubmit);

    }

}
