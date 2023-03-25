package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage extends CommonActionOnPages{
    private final Estudiante estudiante;

    //Localizadores
    private final By clickForms = By.xpath("//div[@class='card mt-4 top-card'][2]");
    private final By clickPracticeForm = By.xpath("//span[@class='text' and contains(text(), 'Practice Form')]");
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By gender1 = By.id("gender-radio-1");
    private final By gender2 = By.id("gender-radio-2");
    private final By gender3 = By.id("gender-radio-3");
    private final By mobile = By.id("userNumber");
    private final By dateBirth = By.id("dateOfBirthInput");
    private final By year = By.className("react-datepicker__year-select");
    private final By month = By.className("react-datepicker__month-select");
    private final By day = By.className("react-datepicker__day--006");
    private final By subjects = By.id("subjectsInput");

    private final By hobbies1 = By.id("hobbies-checkbox-1");
    private final By hobbies2 = By.id("hobbies-checkbox-2");
    private final By hobbies3 = By.id("hobbies-checkbox-3");

    private final By currentAddress = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By submit = By.id("submit");

    private final By finalName = By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)");

    //Constructor
    public FormPage(WebDriver driver, Estudiante estudiante) {
        super(driver);
        this.estudiante = estudiante;
    }

    public void NavegarFormulario() {
        click(clickForms);
        click(clickPracticeForm);
    }

    public void fillMandatoryFields() {
        clearText(name);
        typeInto(name,estudiante.getName());

        clearText(lastName);
        typeInto(lastName,estudiante.getLastName());

        clearText(email);
        typeInto(email, estudiante.getEmail());

        switch (estudiante.getGender()) {
            case MALE:
                pressSpace(gender1);
                break;
            case FEMALE:
                pressSpace(gender2);
                break;
            case OTHER:
                pressSpace(gender3);
                break;
            default:
        }

        clearText(mobile);
        typeInto(mobile, estudiante.getMobile());

        click(dateBirth);
        typeInto(year, estudiante.getYear());
        typeInto(month, estudiante.getMonth());
        click(day);

        typeInto(subjects,"Maths");
        pressEnter(subjects);
        typeInto(subjects,"Physics");
        pressEnter(subjects);

        for (int i = 0; i < estudiante.getHobbies().size(); i++) {
            switch (estudiante.getHobbies().get(i)) {
                case SPORTS: pressSpace(hobbies1);
                case READING: pressSpace(hobbies2);
                case MUSIC: pressSpace(hobbies3);
            }
        }

        typeInto(currentAddress,estudiante.getCurrentAddress());

        typeInto(state,estudiante.getState());
        pressEnter(state);

        typeInto(city,estudiante.getCity());
        pressEnter(city);

        pressSpace(submit);
    }

    public WebElement getMensajeFinal(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(finalName));
    }

}
