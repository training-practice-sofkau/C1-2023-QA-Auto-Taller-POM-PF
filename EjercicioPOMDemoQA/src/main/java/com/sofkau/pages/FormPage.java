package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormPage extends CommonActionOnPage{
    private final Estudiante estudiante;

    /**
     * Localizadores
     */
    private final By form = By.xpath("(//div[@class='avatar mx-auto white'])[2]");
    private final By practiceForm = By.xpath("(//span[normalize-space()='Practice Form'])[1]");
    private final By name = By.id("firstName");
    private final By lastname = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.id("gender-radio-1");
    private final By genderFemale = By.id("gender-radio-2");
    private final By genderOther = By.id("gender-radio-3");
    private final By number = By.id("userNumber");
    private final By date = By.id("dateOfBirthInput");
    private final By calendar = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");
    private final By textArea = By.id("currentAddress");
    private final By nameState = By.id("react-select-3-input");
    private final By nameCity = By.id("react-select-4-input");
    private final By sport = By.id("hobbies-checkbox-1");
    private final By reading = By.id("hobbies-checkbox-2");
    private final By music = By.id("hobbies-checkbox-3");
    private final By button = By.id("submit");
    private final By nameModal = By.xpath("(//table//tr//td)[2]");

    public FormPage(WebDriver driver, Estudiante estudiante) {
        super(driver);
        this.estudiante = estudiante;
    }

    public void ingresoFormulario(){
        click(form);
        click(practiceForm);
    }

    public void fillmandatoryFields(){
        clearText(name);
        typeInto(name, estudiante.getName());
        clearText(lastname);
        typeInto(lastname, estudiante.getLastName());
        clearText(email);
        typeInto(email, estudiante.getEmail());
        switch (estudiante.getGender()) {
            case MALE:
                pressSpace(genderMale);
                break;
            case FEMALE:
                pressSpace(genderFemale);
                break;
            case OTHER:
                pressSpace(genderOther);
                break;
            default:
        }
        pressSpace(genderFemale);
        clearText(number);
        typeInto(number, estudiante.getMobile());
        selectAllText(calendar);
        typeInto(calendar, estudiante.getDateOfBirth());
        pressEscape(calendar);
        List<String> subjects = estudiante.getSubjects();
        for(String item:subjects){
            typeInto(subject, item);
            pressEnter(subject);
        }
        clearText(textArea);
        typeInto(textArea, estudiante.getCurrentAdress());
        clearText(nameState);
        typeInto(nameState, estudiante.getState());
        pressEnter(nameState);
        clearText(nameCity);
        typeInto(nameCity, estudiante.getCity());
        pressEnter(nameCity);
        for (int i = 0; i < estudiante.getHobbies().size(); i++) {
            switch (estudiante.getHobbies().get(i)) {
                case READING: pressSpace(reading);
                case MUSIC: pressSpace(music);
            }
        }
        pressSpace(button);
    }

    public WebElement getMensajeFinal(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameModal));
    }
}