package com.sofkau.stepdefinitions;

import com.sofkau.pages.WebTablePage;
import com.sofkau.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TableStepDefinition extends WebUi {

    @Given("se encuentra en la pagina principal")
    public void se_encuentra_en_la_pagina_principal() {
        generalSetup();
    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() {
        WebTablePage webTablePage=new WebTablePage(super.driver);
        webTablePage.navigacionPaginaInicial();
    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String nombre, String apellido, String edad, String correo, String salario, String departamento) throws InterruptedException {
        WebTablePage webTablePage =new WebTablePage(super.driver);
        webTablePage.fillMandatoryFields(nombre,apellido,edad,correo,salario,departamento);
        webTablePage.valorDatosIngresados(nombre,apellido,edad,correo,salario,departamento);

    }


    @Then("debe observar una tabla con la informacion ingresada correctamente")
    public void debe_observar_una_tabla_con_la_informacion_ingresada_correctamente() {
        try {
            Assertions.assertEquals(WebTablePage.datosIngresados, WebTablePage.datosTablaVisualizacion);
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
        }finally {

            quiteDriver();
        }
    }
}
