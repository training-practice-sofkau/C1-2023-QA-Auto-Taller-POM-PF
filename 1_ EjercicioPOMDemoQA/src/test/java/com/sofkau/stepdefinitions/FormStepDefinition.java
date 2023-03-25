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
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FormStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(FormStepDefinition.class);
    Estudiante estudiante = new Estudiante();

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        try {
            generalSetUp();
            LOGGER.info("inicio de la automatizacion ");
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("navega hasta la opcion de los formularios")
    public void navegaHastaLaOpcionDeLosFormularios() {
        try {
            FormPage formPage = new FormPage(super.driver, estudiante);
            formPage.NavegarFormulario();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        try {
            setData();
            FormPage formPage = new FormPage(super.driver, estudiante);
            formPage.fillMandatoryFields();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("entonces debe observar una ventana con la informacion ingresada")
    public void entoncesDebeObservarUnaVentanaConLaInformacionIngresada()  {
        try {
            String nombreEsperado = "Jesus Molina";
            FormPage formPage = new FormPage(super.driver, estudiante);
            String nombreActual = formPage.getMensajeFinal(driver).getText();
            assertEquals(nombreEsperado, nombreActual);
            LOGGER.info("VALOR ESPERADO: " + nombreEsperado);
            LOGGER.info("VALOR OBTENIDO: " + nombreActual);
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }

    }

    public void setData() {
        estudiante.setName("Jesus");
        estudiante.setLastName("Molina");
        estudiante.setEmail("jesusmolina@gmail.com");
        estudiante.setGender(Gender.MALE);
        estudiante.setMobile("1234567890");
        estudiante.setYear("1996");
        estudiante.setMonth("Febrary");
        estudiante.setDay("006");
        estudiante.setSubjects(Arrays.asList("Maths","Physics"));
        estudiante.setHobbies(Arrays.asList(Hobbies.SPORTS, Hobbies.READING, Hobbies.MUSIC));
        estudiante.setCurrentAddress("Av 4 # 16-16 San luis");
        estudiante.setPicture("imagen.jpg");
        estudiante.setState("Uttar Pradesh");
        estudiante.setCity("Lucknow");
    }

    public List<String> elementsForRegister() {
      List<String> submitFormResult = new ArrayList<>();
      submitFormResult.add((estudiante.getName() + " " + estudiante.getLastName()).trim());
      submitFormResult.add((estudiante.getEmail()).trim());
      submitFormResult.add((estudiante.getGender().getValue()).trim());
      submitFormResult.add((estudiante.getMobile()).trim());
      return submitFormResult;
    }


}
