package com.sofkau.stupdefinitions;

import com.sofkau.model.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ht.E;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class FormStepDefinition extends WebUI {


    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la automatizacion");

    }

    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.formulario();
        LOGGER.info("Formulario disponible para llenar datos");
    }

    @When("complementa los campos con la informacion del estudiante")
    public void complementaLosCamposConLaInformacionDelEstudiante() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        Estudiante estudiante = new Estudiante("Yolima", "Alejandra", "al@gmail.com", Gender.FEMALE, "3177378803","13 March,2003", Arrays.asList("Maths"), Hobbies.SPORTS, "Cra 2a 45b -29","Haryana", "Karnal");
        formPage.fillMandatoryFields(estudiante);
        LOGGER.info("Los datos fueron llenados de manera correcta en el formulario");
    }


    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException {



        LOGGER.info("Resultados de prueba:");
        try {
            for(int i=0;i<9;i++){
                Assertions.assertEquals(FormPage.esperados.get(i),FormPage.obtenidos.get(i));
                LOGGER.info("la prueba cumple la asserción " );

            }
        } catch (Throwable e) {
            LOGGER.warning("Error. Los valores esperados y obtenidos no coinciden");
        }
        quiteDriver();

    }





}
