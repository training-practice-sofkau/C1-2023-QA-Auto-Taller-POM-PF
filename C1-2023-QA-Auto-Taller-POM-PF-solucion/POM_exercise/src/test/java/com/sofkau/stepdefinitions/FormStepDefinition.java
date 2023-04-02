package com.sofkau.stepdefinitions;

import com.sofkau.models.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(FormStepDefinition.class);
    Estudiante e;
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("inicio de la automatizacion");

    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() {
        informationStudents();
        FormPage formPage= new FormPage(super.driver,e);
        formPage.fillMandatoryFields();

    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {

    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() {

        WebElement table = driver.findElement(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<String> values = new ArrayList<String>();

        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            if (cols.size() > 1) {
                String value = cols.get(1).getText();
                values.add(value);
            }
        }


        String[] valoresEsperados = {"Melissa Meneses", "melimenesesacevedo@gmail.com",
                "Female", "3127357861", "04 Sep ,2002", "Sports", "Reading", "Music", "calle 49#57a-109-copa",
                "NCR Noida"};
        String[] valoresActuales = values.toArray(new String[0]);

        try {
            Assertions.assertArrayEquals(valoresEsperados,valoresActuales);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        }finally {
            quiteDriver();
        }


    }


    public void informationStudents(){
        e= new Estudiante();

        e.setName("Mari");
        e.setSecondname("Meneses");
        e.setEmail("melimenesesacevedo@gmail.com");
        e.setGender(Gender.FEMALE);
        e.setMobile("3127357861");
        e.setDate("04 september 2002");
        e.setSubject("Mathe");
        e.setCurrentAddres("calle 49#57a-109-copa");
        e.setState("NCR");
        e.setCity("Noida");


    }
}
