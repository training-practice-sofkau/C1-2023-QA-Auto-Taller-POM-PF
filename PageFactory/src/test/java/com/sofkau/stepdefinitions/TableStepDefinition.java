package com.sofkau.stepdefinitions;

import com.sofka.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import org.apache.log4j.Logger;

public class TableStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(TableStepDefinition.class));

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        try {
            generalSetup();
            LOGGER.info("Inicio de la automatización");
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() {
        try {
            FormPage formPage = new FormPage(super.driver);
            formPage.ingresoTabla();
        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String nombre, String apellido, String edad, String correo, String salario, String departamento) {
        try {
            FormPage formPage = new FormPage(super.driver);
            formPage.fillmandatoryFields(nombre, apellido, edad, correo, salario, departamento);

        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @Then("debe observar una tabla con la informacion ingresada {string} {string} {string}")
    public void debeObservarUnaTablaConLaInformacionIngresada(String nombre, String edad, String correo) {
        try {
            String nombreEsperado = nombre;
            String edadEsperada = edad;
            String correoEsperado = correo;

            FormPage formPage = new FormPage(super.driver);
            String nombreRecibido = formPage.getNameTable(driver).getText();
            String edadRecibida = formPage.getAgeTable(driver).getText();
            String correoRecibido = formPage.getEmailTable(driver).getText();

            Assertions.assertEquals(nombreEsperado, nombreRecibido);
            Assertions.assertEquals(edadEsperada, edadRecibida);
            Assertions.assertEquals(correoEsperado, correoRecibido);

        }catch (Exception e){
            quiteDriver();
            Assertions.fail(e.getMessage(),e);
            LOGGER.warn(e.getMessage(), e);
        }
    }
}
