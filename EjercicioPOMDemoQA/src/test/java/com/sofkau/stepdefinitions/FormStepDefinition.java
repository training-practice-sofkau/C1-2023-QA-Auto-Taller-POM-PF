package com.sofkau.stepdefinitions;

import com.sofkau.models.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER=Logger.getLogger(FormStepDefinition.class);
    Estudiante estudiante = new Estudiante();

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        try{
            generalSetup();
            LOGGER.info("Inicio de la automatización");
        }catch(Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() {
        try{
            FormPage formPage = new FormPage(super.driver, estudiante);
            formPage.ingresoFormulario();
        }catch(Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @When("complete los campos con la informacion del estudiante")
    public void completeLosCamposConLaInformacionDelEstudiante() {
        try{
            estudiante.setName("Gretty");
            estudiante.setLastName("Mosquera");
            estudiante.setEmail("gretym@gmail.com");
            estudiante.setMobile("3107254898");
            estudiante.setGender(Gender.FEMALE);
            estudiante.setYear("1990");
            estudiante.setMonth("December");
            estudiante.setDay("12");
            estudiante.setSubjects(new ArrayList<>(Arrays.asList("Commerce", "Economics", "English")));
            estudiante.setCurrentAdress("Ejemplo de un texto");
            estudiante.setHobbies(Arrays.asList(Hobbies.READING, Hobbies.MUSIC));
            estudiante.setState("Haryana");
            estudiante.setCity("Karnal");

            FormPage formPage = new FormPage(super.driver, estudiante);
            formPage.fillmandatoryFields();
        }catch(Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException {
        try{
            FormPage formPage = new FormPage(super.driver, estudiante);
            String nombreEsperado = "Gretty Mosquera";
            String nombreObtenido = formPage.getMensajeFinal(driver).getText();
            Assertions.assertEquals(nombreEsperado, nombreObtenido);
        }catch(Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }finally {
            quiteDriver();
        }
    }
}