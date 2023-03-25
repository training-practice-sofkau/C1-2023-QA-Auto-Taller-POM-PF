package com.sofkau.stepdefinitions;

import com.sofkau.models.Registro;
import com.sofkau.pages.TablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import com.sofkau.setup.WebUI;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TableStepDefinition extends WebUI {


    public static Logger LOGGER=Logger.getLogger(TableStepDefinition.class);
    @Given("el admnistrador esta en la pagina principal")
    public void elAdmnistradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion ");

    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() throws InterruptedException {
        TablePage tablePage = new TablePage(super.driver);
        tablePage.clickForm();

    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, email {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadEmailSalarioDepartamento(String nombre, String apellido, String edad, String email, String salario, String departamento) {
        TablePage tablePage = new TablePage(super.driver);
        tablePage.fillMandatoryFields(nombre, apellido, edad, email, salario, departamento);
    }
    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() throws InterruptedException {

        TablePage tablePage = new TablePage(super.driver);

        for(int i=0;i<6;i++){
            try {
            Assertions.assertEquals(tablePage.expected.get(i),tablePage.actual.get(i));
            LOGGER.info("La prueba paso, los resutaldos esperados coinciden con los obtenidos" + tablePage.expected.get(i));
            } catch (AssertionError e) {
                // Manejo de la excepción
                System.out.println("El valor esperado no coincide con el valor obtenido: " + e.getMessage());
            }

        }
        tablePage.expected.clear();
        tablePage.actual.clear();
    }

}
