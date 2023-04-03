package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.Assert;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info(" inicio de la automatizacion");
    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() throws InterruptedException {
        FormPage formPage= new FormPage(super.driver);
        formPage.navegando();
    }
    @When("completa con nombre {string}, apellido {string}, correo electronico {string} , edad {string}, salario {string}, departamento {string}")
    public void completa_con_nombre_apellido_correo_electronico_edad_salario_departamento(String firstName, String lastName, String email , String age, String salary, String department) {
        FormPage formPage= new FormPage(super.driver);
        formPage.fillMandatoryFields(firstName, lastName, email, age,salary, department);
    }

    @Then("debe observar una fila con la informacion ingresada en la tabla.")
    public void debeObservarUnaFilaConLaInformacionIngresadaEnLaTabla() {
        FormPage formPage = new FormPage(super.driver);
        boolean isButtonPresent = formPage.isButtonPresent();
        Assert.assertTrue("El boton no se encuentra en la pagina.", isButtonPresent);

    }
}


