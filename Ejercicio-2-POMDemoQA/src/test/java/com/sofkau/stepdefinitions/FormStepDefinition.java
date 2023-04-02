package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info(" inicio de la automatizacion");
    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() {

    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String nombre, String apellido, String edad, String correo, String salario, String departamento) {

    }
    @Then("debe observar una fila con la informacion ingresada en la tabla.")
    public void debeObservarUnaFilaConLaInformacionIngresadaEnLaTabla() {

    }
}


