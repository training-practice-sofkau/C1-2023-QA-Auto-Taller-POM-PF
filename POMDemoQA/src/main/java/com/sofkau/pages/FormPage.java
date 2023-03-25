package com.sofkau.pages;

import com.sofkau.model.Estudiante;
import com.sofkau.util.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.Locator;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;

public class FormPage  extends CommonActionOnPages{

    public static ArrayList<String> esperados = new ArrayList<>();
    public static ArrayList<String> obtenidos = new ArrayList<>();
    /**
     *Localizadores
     */
    private final By form = By.xpath("(//div[@class='avatar mx-auto white'])[2]");
    private final By practiceForm = By.xpath("(//span[normalize-space()='Practice Form'])[1]");
    private final By name = By.id("firstName");
    private final By lastname = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.xpath("  //label[normalize-space()='Male']");
    private final By genderFemale = By.xpath(" //label[normalize-space()='Female']");
    private final By genderOther = By.xpath("//label[normalize-space()='Other']");
    private final By movil = By.id("userNumber");
    private final By birth = By.id("dateOfBirthInput");
    private final By subject = By.id("subjectsInput");

    private final By sport = By.id("hobbies-checkbox-1");
    private final By reading = By.id("hobbies-checkbox-2");
    private final By music = By.id("hobbies-checkbox-3");

    private final By address = By.id("currentAddress");

    private final By state = By.id("react-select-3-input");

    private final By city = By.id("react-select-4-input");

    private final By submit = By.id("submit");


    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void fillMandatoryFields(Estudiante estudiante){
        clearText(name);
        typeInto(name, estudiante.getName());
        esperados.add("Yolima Alejandra");
        clearText(lastname);
        typeInto(lastname,estudiante.getLastName());
        //esperados.add("Yolima Alejandra");
        clearText(email);
        typeInto(email, estudiante.getEmail());
        esperados.add(estudiante.getEmail());
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
        esperados.add("Female");
        typeInto(movil, estudiante.getMobile());
        esperados.add(estudiante.getMobile());
        clearText(birth);
        sendDate(birth, estudiante.getFecha());
        esperados.add(estudiante.getFecha());

        List<String> subjects = estudiante.getSubject();
        for(String sub1: subjects){
            typeInto(subject, sub1);
            pressEnter(subject);
        }
       esperados.add("Maths");

        switch (estudiante.getHobbies()) {
            case SPORTS:
                pressSpace(sport);
                break;
            case READING:
                pressSpace(reading);
                break;
            case MUSIC:
                pressSpace(music);
                break;
            default:
        }
       esperados.add("Sports");
        clearText(address);
        typeInto(address, estudiante.getCurrentAddres());
        esperados.add("Cra 2a 45b -29");
        typeInto(state, estudiante.getState());
        pressEnter(state);
        esperados.add("Haryana");
        typeInto(city, estudiante.getCity());
        pressEnter(city);
        esperados.add("Karnal");
        pressSpace(submit);
        resultado();
    }

    public void formulario() {
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("scrollBy(0,500);");
        click(form);
        click(practiceForm);
    }
    public void resultado(){
        WebElement element;
        setZoom(55);
        for(int i=2;i<=20;i++){
            if(i==16)
                i+=2;
            if(i==20) {

                break;
            }
            element= driver.findElement(By.xpath("(//td)["+i+"]"));
            obtenidos.add(element.getText());
            i++;
        }
    }

   }
