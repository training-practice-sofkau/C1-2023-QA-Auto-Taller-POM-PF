package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FormPage extends CommonActionOnPages {
    private final Estudiante estudiante;

   private final By form = By.xpath("//div[@class='card mt-4 top-card'][2]");
    private final By practiceForm = By.xpath("(//span[normalize-space()='Practice Form'])[1]");

    private final By name = By.id("firstName");
    private final By lastname=By.id("lastName");
    private final By email =By.id("userEmail");
    private final By gender1 = By.id("gender-radio-1");
    private final By gender2 = By.id("gender-radio-2");
    private final By gender3 = By.id("gender-radio-3");
   // private final By gender =By.id("gender-radio-1");
    private final By mobil =By.id("userNumber");

    private final By birth = By.id("dateOfBirthInput");
    private final By subjects = By.id("subjectsInput");

    private final By sports=By.id("hobbies-checkbox-1");

    private final By reading=By.id("hobbies-checkbox-2");

    private final By music=By.xpath("//*[text()='Music']");

    private  final  By adressUsuario   = By.id("currentAddress");
    private final By selectstate = By.id("react-select-3-input");
   private final By selectcity = By.id("react-select-4-input");

    private final By btnsubmit = By.id("submit");

    public FormPage(WebDriver driver, Estudiante estudiante) {
        super(driver);
        this.estudiante = estudiante;
    }


    public void Inicio() throws InterruptedException{
      // scrollto(form);
       // click(form);
        Thread.sleep(3000);
      //click(practiceForm);
    }

    public void  fillMandatoryFields(){
        //setZoom(65);
        clearText(name);
        typeInto(name,estudiante.firstName());
        clearText(lastname);
        typeInto(lastname,estudiante.lastName());
        clearText(email);
        typeInto(email, estudiante.email());

        switch (estudiante.gender()) {
            case FEMALE:
                presSpace(gender1);
                break;
            case MALE:
                presSpace(gender2);
                break;
            case OTHER:
                presSpace(gender3);
                break;
            default:
        }

      // presSpace(gender1);
       // clearText(mobil);

        typeInto(mobil, estudiante.mobileNumber());
        sendDate(birth,estudiante.dateOfBirth());

        clearText(subjects);
        typeInto(subjects,"English");
        tab(subjects);
        /*
        presSpace(sports);
        presSpace(reading);
       // presSpace(music);
        //clearText(addresUsuario);
       typeInto(adressUsuario,"Mz 29-15");

        presSpace (selectstate);
        typeInto(selectstate, "NCR");
        pressEnter(selectstate);
        presSpace(selectcity);
        typeInto(selectcity, "Delhi");
        pressEnter(selectcity);

         */
        presSpace(btnsubmit);

       // typeInto(name,estudiante.name);
       // typeInto(lastname, estudiante);

    }

}
