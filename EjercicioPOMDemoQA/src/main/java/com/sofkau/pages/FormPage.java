package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import com.sofkau.util.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FormPage extends CommonActionOnPages {


    // Se debe corregir los clicks en la pagina de inicio, no me da por alguna razón
    private final By inicio = By.xpath("//div[@class='card mt-4 top-card'][2]");
    private final By clickForm = By.xpath("//*[text()='Practice Form']");
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By userNumber = By.id("userNumber");
    private final By selectMale = By.id("gender-radio-1");
    private final By selectFemale = By.id("gender-radio-2");
    private final By selectOther = By.id("gender-radio-3");
    private final By dateofBirth = By.id("dateOfBirthInput");
    private final By hobbieSport = By.id("hobbies-checkbox-1");
    private final By hobbieReading = By.id("hobbies-checkbox-2");
    private final By hobbieMusic = By.id("hobbies-checkbox-3");
    private final By subjects = By.id("subjectsInput");
    private final By state = By.id("react-select-3-input");
    private final By city = By.id("react-select-4-input");
    private final By submit = By.cssSelector("#submit");
    private final By adressUsuario = By.id("currentAddress");


    // Localizadores para verificar la data

    private final By confirmName = By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)");
   

    private final Estudiante estudiante;


    //constructor
    public FormPage(WebDriver driver, Estudiante estudiante) {
        super(driver);
        this.estudiante = estudiante;
    }

    public void FillMandatoryFields() {
        setZoom(50);

        typeInto(name, estudiante.getName());
        System.out.println(" Imprime?  " + estudiante.getName());
        typeInto(lastName, estudiante.getLastName());
        typeInto(email, estudiante.getEmail());

        // Switch para seleccionar el generoen relación a la clase enum

        switch (estudiante.getGender()) {
            case MALE:
                pressSpace(selectMale);
                break;
            case FEMALE:
                pressSpace(selectFemale);
                break;
            case OTHER:
                pressSpace(selectOther);
                break;
            default:
        }


        typeInto(userNumber, estudiante.getUserNumber());

        // Lista para guardar las materias y seleccionarlas con el for

        List listSubjects = estudiante.getSubjects();
        for (Object listSubject : listSubjects) {
            typeInto(subjects, (String) listSubject);
            pressEnter(subjects);
        }

        //Switch para seleccionar la lista de hobbies
        List<Hobbies> listHobbies = estudiante.getHobbies();
        for (Object listHobby : listHobbies) {
            switch ((Hobbies) listHobby) {
                case SPORTS:
                    pressSpace(hobbieSport);
                    break;
                case READING:
                    pressSpace(hobbieReading);
                    break;
                case MUSIC:
                    pressSpace(hobbieMusic);
                    break;
            }

        }

        typeInto(adressUsuario, estudiante.getAdressUsuario());

        System.out.println("confirmName = " + confirmName);


        pressSpace(state);
        typeInto(state, estudiante.getState());
        pressEnter(state);

        pressSpace(city);
        typeInto(city, estudiante.getCity());
        pressEnter(city);
        calendar(dateofBirth, estudiante.getDateofBirth());
        System.out.println("estudiante.getDateofBirth() = " + estudiante.getDateofBirth());
        pressSpace(submit);


/*


        //clearText( name);
        typeInto(name, "Santy");
        //clearText( lastName);
        typeInto(lastName, "Ramirez");
        //clearText( email);
        typeInto(email, "correo@jemplo.com");
        //clearText( userNumber);
        typeInto(userNumber, "230920001");
        pressSpace(selectMale);
        calendar(dateofBirth, "23/09/2001");
        pressSpace(hobbieSport);
        typeInto(subjects, "Math");
        pressEnter(subjects);
        typeInto(subjects, "English");
        pressEnter(subjects);
        pressSpace(state);
        typeInto(state, "NCR");
        pressEnter(state);
        pressSpace(city);
        typeInto(city, "Delhi");
        pressEnter(city);
        typeInto(adressUsuario, "Calle 123");
        pressSpace(submit);

*/
    }


    // Falta implementar
    public void inicioPagina() throws InterruptedException {
        setZoom(75);
        click(inicio);
        Thread.sleep(2000);
        click(clickForm);
    }


    public List<String>  dataObtained () {
        List<String> results = new ArrayList<>();
        results.add(getText((WebElement) confirmName).trim());
        return results;
    }
}
