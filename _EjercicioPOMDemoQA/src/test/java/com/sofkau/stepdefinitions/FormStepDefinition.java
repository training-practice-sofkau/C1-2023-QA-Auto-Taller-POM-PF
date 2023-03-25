package com.sofkau.stepdefinitions;

import com.sofkau.models.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.logging.Logger;

public class FormStepDefinition  extends WebUI {
    Estudiante estudiante;
    
    public static Logger LOGGER=Logger.getLogger(String.valueOf(FormStepDefinition.class));
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la automatización");
    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver, estudiante);
        formPage.Inicio();

    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        crearEstudiante();
        FormPage formPage = new FormPage(super.driver, estudiante);
        formPage.fillMandatoryFields();

    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException {
        Thread.sleep(3000);
        quiteDriver();
        LOGGER.info("|Esperado|Real|Valor|");
        Assert.assertEquals("Emilia", estudiante.firstName());
        Assert.assertEquals("Ospina", estudiante.lastName());
        Assert.assertEquals("ospina_88@gmail.com", estudiante.email());
        Assert.assertEquals("31545678765", estudiante.mobileNumber());
        Assert.assertEquals("25 Junio 2012", estudiante.dateOfBirth());
    }

    public void crearEstudiante(){
        estudiante = new Estudiante();
        estudiante.setFirstName("Emilia");
        estudiante.setLastName("Ospina");
        estudiante.setEmail("ospina_88@gmail.com");
        estudiante.setGender(Gender.FEMALE);
        estudiante.setMobileNumber("31545678765");
        estudiante.setDateOfBirth("25 Junio 2012");
    }
}
