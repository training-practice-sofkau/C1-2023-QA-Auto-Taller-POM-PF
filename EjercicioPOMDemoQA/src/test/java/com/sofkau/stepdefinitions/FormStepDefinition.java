package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.logging.Logger;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER=Logger.getLogger(String.valueOf(FormStepDefinition.class));
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal(){
        generalSetUp();
        LOGGER.info("Inicio de la automatizacion");

    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() {
        try{
            FormPage formPage=new FormPage(super.driver);
            formPage.navigatePage();
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }


    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() throws InterruptedException {
        try{
            FormPage formPage=new FormPage(super.driver);
            formPage.fillMandatoryFields();
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }


    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException {
        try {
            Assertions.assertEquals(FormPage.datosIngresados,FormPage.datosTablas);
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
        }finally {
            Thread.sleep(5000);
            quiteDriver();
            LOGGER.info("Se finaliza la automatizacion");
        }

    }

}
