package com.sofkau.stepdefinitions;

import com.sofkau.pages.TablePage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;


public class TableStepDefinition extends WebUI {
    public static Logger LOGGER=Logger.getLogger(TableStepDefinition.class);


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
    @When("navega hasta la opcion de elementos")
    public void navegaHastaLaOpcionDeElementos() throws InterruptedException {

       try {
            TablePage tablePage = new TablePage(super.driver);
            tablePage.navegarTabla();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, correo {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoSalarioDepartamento(String nombre, String apellido, String edad, String correo, String salario, String departamento) {

       try {
            TablePage tablePage = new TablePage(super.driver);
            tablePage.fillMandatoryFields(nombre, apellido, edad, correo, salario, departamento);

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    @Then("entonces debe observar una ventana con la informacion ingresada de nombre {string}, apellido {string}, edad {string}")
    public void entoncesDebeObservarUnaVentanaConLaInformacionIngresadaDeNombreApellidoEdad(String nombre, String apellido, String edad) {
        try {
            String nombreEsperado = nombre;
            String apellidoEsperado = apellido;
            String edadEsperada = edad;
            TablePage tablePage = new TablePage(super.driver);
            String nombreActual = tablePage.getNameFinal(driver).getText();
            String apellidoActual = tablePage.getLastNameFinal(driver).getText();
            String edadActual = tablePage.getAgeFinal(driver).getText();

            assertEquals(nombreEsperado,nombreActual);
            assertEquals(apellidoEsperado,apellidoActual);
            assertEquals(edadEsperada,edadActual);
            LOGGER.info("VALORES ESPERADOS: Nombre: " + nombreEsperado + ", Apellido: " + apellidoEsperado + ", Edad: " + edadEsperada);
            LOGGER.info("VALORES OBTENIDOS: Nombre: " + nombreActual + ", Apellido: " + apellidoActual + ", Edad: " + edadActual);

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }

    }

}

