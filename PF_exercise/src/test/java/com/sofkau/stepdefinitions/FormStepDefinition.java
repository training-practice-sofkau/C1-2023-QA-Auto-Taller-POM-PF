package com.sofkau.stepdefinitions;
import com.sofka.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import java.util.HashSet;
import java.util.Set;


public class FormStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));


    @Given("el admin esta en la pagina principal de DemoQA")
    public void elAdminEstaEnLaPaginaPrincipalDeDemoQA() {
        try {
            generalSetUp();
            LOGGER.info("Inicio de la Automatizacion correcatmente ");
        } catch (Exception e) {
            LOGGER.error("Error al iniciar la Automatizacion: " + e.getMessage());
            throw e;
        }

    }
    @When("navega hasta la opcion de Web Tables")
    public void navegaHastaLaOpcionDeWebTables() throws InterruptedException {
        try {
            FormPage formPage = new FormPage(super.driver);
            formPage.clickForm();
        } catch (Exception e) {
            LOGGER.error("Error al navegar hasta la opción de Web Tables: " + e.getMessage());
            throw e;
        }

    }
    @When("da click en el boton de agregar un nuevo registro")
    public void daClickEnElBotonDeAgregarUnNuevoRegistro() {
        try {
            FormPage formPage = new FormPage(super.driver);
            formPage.clickADD();
        } catch (Exception e) {
            LOGGER.error("Error al dar click en el botón de agregar un nuevo registro: " + e.getMessage());
            throw e;
        }

    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, correo {string}, salario {string}, departamento {string}")
    public void completa_con_nombre_apellido_edad_correo_salario_departamento(String nombre, String apellido, String edad, String correo, String salario, String departamento) {
        try {
            FormPage formPage = new FormPage(super.driver);
            formPage.ingresoInformacion(nombre,apellido,correo,edad,salario,departamento);
        } catch (Exception e) {
            LOGGER.error("Error al completar la información del formulario: " + e.getMessage());
            throw e;
        }
    }

    @When("envia la informacion")
    public void enviaLaInformacion() {

    }
    @Then("debe observar una tabla de la informacion ingresada correctamente")
    public void debeObservarUnaTablaDeLaInformacionIngresadaCorrectamente() throws InterruptedException {
        try {
            FormPage formPage = new FormPage(super.driver);
            Set<String> obtained = new HashSet<>(formPage.obtenido);
            Set<String> expected = new HashSet<>(formPage.esperado);
            Assert.assertEquals("La tabla obtenida no coincide con la informacion ingresada", expected, obtained);
            LOGGER.info("La tabla obtenida coincide con la información ingresada.");
            quiteDriver();
        } catch (Exception e) {
            LOGGER.error("Error al observar la tabla de la información ingresada correctamente: " + e.getMessage());
            throw e;
        }
    }



}
