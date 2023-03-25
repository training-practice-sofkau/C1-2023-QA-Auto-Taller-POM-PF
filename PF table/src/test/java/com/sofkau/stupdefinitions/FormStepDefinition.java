package com.sofkau.stupdefinitions;

import com.sofkaU.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class FormStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion");
    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickForm();
        LOGGER.info("Pagina web lista para registro de datos");

    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String string, String string2, String int1, String string3, String int2, String string4) {
        FormPage formPage=new FormPage(super.driver);
        formPage.fillMandatoryFields(string,string2,int1,string3,int2,string4);
        LOGGER.info("Los campos fueron llenados con exito");
    }
    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() throws InterruptedException {

        try {
            for(int i=0;i<6;i++){
                Assertions.assertEquals(FormPage.esperados.get(i),FormPage.obtenidos.get(i));

            }
            FormPage.esperados.clear();
            FormPage.obtenidos.clear();
            LOGGER.info("Prueba desarollada con exito");
            quitDriver();
        } catch (Exception e) {
            LOGGER.warn("Prueba fallida");
            quitDriver();
        }
    }
    }


