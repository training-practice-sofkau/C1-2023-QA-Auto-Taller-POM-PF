package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class FormStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() throws InterruptedException {
        generalSetUp();
        LOGGER.info("inicio de la automatizacion");
    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() {

    }

    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String nombre, String apellido, String edad, String correo, String salario, String departamento) {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields(nombre, apellido, edad, correo, salario, departamento);
    }


    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() throws InterruptedException {
        Thread.sleep(5000);
        try {
            FormPage formPage = new FormPage(super.driver);
            Assertions.assertNotNull(formPage.getName());
            Assertions.assertNotNull(formPage.getEmail());
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDriver();
        }
    }
}
