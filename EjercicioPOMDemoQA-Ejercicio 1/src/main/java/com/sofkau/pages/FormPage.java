package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class FormPage extends CommonActionsOnPages{

    private final By iconoForm = By.xpath("(//div[contains(@class, 'card mt-4 top-card')])[2]");
    private final By form = By.xpath("//li[@id='item-0']//span[text()='Practice Form']");
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By male = By.id("gender-radio-1");
    private final By female = By.id("gender-radio-2");
    private final By other = By.id("gender-radio-3");
    private final By number = By.id("userNumber");
    private final By dateBirth = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");
    private final By sports = By.id("hobbies-checkbox-1");
    private final By read = By.id("hobbies-checkbox-2");
    private final By music = By.id("hobbies-checkbox-3");
    private final By addres = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By btnSubmit = By.id("submit");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void fillMandatoryFields(Estudiante estudiante){
        setZoom(67);

        clearText(firstName);
        typeInto(firstName, estudiante.getName());
        clearText(lastName);
        typeInto(lastName, estudiante.getApellido());
        clearText(email);
        typeInto(email, estudiante.getEmail());

        Gender gender = estudiante.getGender();
        switch (gender) {
            case MALE:
                pressSpace(male);
                break;
            case FEMALE:
                pressSpace(female);
                break;
            case OTHER:
                pressSpace(other);
                break;
        }

        clearText(number);
        typeInto(number, estudiante.getMobile());
        sendDate(dateBirth, estudiante.getDateOfBirth());

        List<String> subjects = estudiante.getSubject();
        for (String subject1 : subjects) {
            typeInto(subject, subject1);
            pressEnter(subject);
        }

        Hobbies hobbies = estudiante.getHobbies();
        switch (hobbies) {
            case SPORTS:
                pressSpace(sports);
                break;
            case READING:
                pressSpace(read);
                break;
            case MUSIC:
                pressSpace(music);
                break;
        }

        clearText(addres);
        typeInto(addres, estudiante.getCurrentAddress());
        typeInto(state, estudiante.getState());
        pressEnter(state);
        typeInto(city, estudiante.getCity());
        pressEnter(city);
        pressSpace(btnSubmit);
    }

    public void navigateToForm(){
        click(iconoForm);
        click(form);
    }
}
