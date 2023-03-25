package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import java.util.stream.IntStream;

import static com.sofkau.pages.FormPage.obtened;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion ");
    }

    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickForm();
    }

    @When("doy click al boton Add de la tabla de registro")
    public void doyClickAlBotonAddDeLaTablaDeRegistro() {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickBtnAddTabla();
    }

    @When("ingreso datos de usuario en la tabla de registro nombre {string}, apellido {string}, edad {string}, correo {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoSalarioDepartamento(String nombre, String apellido, String edad, String correo, String salario, String departamento) {
        FormPage formPage = new FormPage(super.driver);
        formPage.enviarDatosFormulario(nombre, apellido, correo, edad, salario, departamento);
    }

    @When("doy click al boton Submit de la tabla de registro")
    public void doyClickAlBotonSubmitDeLaTablaDeRegistro() {
        FormPage formPage = new FormPage(super.driver);
    }

    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() throws InterruptedException {
        Thread.sleep(3000);
        quiteDriver();
        IntStream.range(0, 6)
                .forEach(i -> {
                    Assertions.assertEquals(FormPage.expected.get(i), obtened.get(i));
                });
        FormPage.expected.clear();
        FormPage.obtened.clear();
    }
}
//       LOGGER.info("");
/*if (FormPage.expected.get(i).equalsIgnoreCase(FormPage.obtened.get(i)))
LOGGER.info(FormPage.expected.get(i) + " | " + FormPage.obtened.get(i) + " | " + "cumple");
else
LOGGER.info(FormPage.expected.get(i) + " | " + FormPage.obtened.get(i) + " | " + "no cumple");
*/
