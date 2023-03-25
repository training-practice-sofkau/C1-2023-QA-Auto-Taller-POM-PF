package com.sofkau.pages;

import com.sofkau.models.Student;
import com.sofkau.util.PracticeForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FormPage extends CommonActionOnPages {

    private final By form = By.xpath("//*[contains(text(), 'Forms')]");
    private final By practiceFormField = By.xpath("//*[contains(text(),'Practice Form')]");
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By mobile = By.id("userNumber");
    private final By genderMale = By.xpath("//*[@for='gender-radio-1']");
    private final By date = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");
    private final By hobbie = By.id("hobbies-checkbox-1");
    private final By address = By.id("currentAddress");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By submit = By.id("submit");
    private final By studentName = By.xpath("//td[text()='Student Name']/following-sibling::td");
    private final By studentEmail = By.xpath("//td[text()='Student Email']/following-sibling::td");
    private final By confirmationMessage = By.id("example-modal-sizes-title-lg");
    public List<String> resultadoList = new ArrayList<>();
    private PracticeForm practiceForm = new PracticeForm();
    private WebDriver driver;


    public FormPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultadoList() {
        return resultadoList;
    }

    public void toForm() throws InterruptedException {
        clickForm(form);
        clickForm(practiceFormField);
    }

    public void fillMandatoryFields() throws InterruptedException{
        practiceForm.fillStudentInfo();
        Student student = practiceForm.getStudent();
        clearText(name);
        typeInto(name, student.getName());
        clearText(lastName);
        typeInto(lastName, student.getLastName());
        clearText(email);
        typeInto(email, student.getEmail());
        clearText(mobile);
        typeInto(mobile, student.getMobile());
        click(genderMale);
        pressSpace(hobbie);
        selectDate(date, student.getDate());
        typeInto(subject, student.getSubject());
        pressEnter(subject);
        typeInto(address, student.getCurrentAdress());
        zoom(80);
        typeInto(state, student.getState());
        pressTab(state);
        typeInto(city, student.getCity());
        pressTab(city);
        clickForm(submit);
    }

    public String getStudentName(){
        return getText(studentName);
    }

    public String getStudentEmail(){
        return getText(studentEmail);
    }
    public String getConfirmationMessage(){
        return getText(confirmationMessage);
    }
}

