package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class FormPage extends CommonActionOnPages{

    private final Estudiante estudiante;


    /**
     * Localizadores
     */
    private final By form = By.xpath("(//div[@class='avatar mx-auto white'])[2]");
    private final By practiceForm = By.xpath("(//span[normalize-space()='Practice Form'])[1]");
    private final By name = By.id("firstName");
    private final By lastname = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.xpath("  //label[normalize-space()='Male']");
    private final By genderFemale = By.xpath(" //label[normalize-space()='Female']");
    private final By genderOther = By.xpath("//label[normalize-space()='Other']");
    private final By mobile = By.id("userNumber");
    private final By date = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");
    private final By hobbie1 = By.id("hobbies-checkbox-1");
    private final By hobbie2 = By.id("hobbies-checkbox-2");
    private final By hobbie3 = By.id("hobbies-checkbox-3");
    private final By currentAddress = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By btnSubmit = By.id("submit");

    public FormPage(WebDriver driver, Estudiante estudiante) {
        super(driver);
        this.estudiante = estudiante;
    }

    public void clickForm() throws InterruptedException {
        click(form);
        Thread.sleep(2000);
        click(practiceForm);
    }

    /**
     * Llenar campos
     */
    public void fillMandatoryFields(){

        //setZoom(80);
        clearText(name);
        typeInto(name, estudiante.getName());

        typeInto(lastname, estudiante.getLastName());

        typeInto(email, estudiante.getEmail());

        switch (estudiante.getGender()) {
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

        typeInto(mobile, estudiante.getMobile());

        selectDate(date, estudiante.getDate());

        List subjects = estudiante.getSubjects();
        for (Object subj : subjects) {
            typeInto(subject,(String) subj);
            tab(subject);
        }

        switch (estudiante.getHobbies()) {
            case HOBBIE1:
                space(hobbie1);
                break;
            case HOBBIE2:
                space(hobbie2);
                break;
            case HOBBIE3:
                space(hobbie3);
                break;
            default:
        }

        clearText(currentAddress);
        typeInto(currentAddress, estudiante.getCurrentAdress());

        typeInto(state, estudiante.getState());
        enter(state);

        typeInto(city, estudiante.getCity());
        enter(city);

        enter(btnSubmit);

    }

}
