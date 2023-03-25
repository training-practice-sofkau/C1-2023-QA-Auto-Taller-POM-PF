package com.sofkau.stepdefinitions;

import com.sofkau.pages.TableSearchPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class TableSearchStepDefinition extends WebUI {
    public static Logger LOGGER= Logger.getLogger(TableStepDefinition.class);
    @Given("el admin esta en la pagina principal de demoqa")
    public void elAdminEstaEnLaPaginaPrincipalDeDemoqa() {
        generalSetup();
        LOGGER.info("Inicio de la automatizacion");
    }
    @When("navega hasta la opcion webtable de demoQA")
    public void navegaHastaLaOpcionWebtableDeDemoQA() throws InterruptedException{
        try {
            TableSearchPage tableSearchPage = new TableSearchPage(super.driver);
            tableSearchPage.navigateToTable();
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }
    @When("escriba el nombre del empleado que necesita")
    public void escribaElNombreDelEmpleadoQueNecesita() throws InterruptedException {
        try {
            TableSearchPage tableSearchPage = new TableSearchPage(super.driver);
            tableSearchPage.searchEmploy("Cierra");
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }

    @Then("debe observar en la tabla solo la informacion de ese empleado")
    public void debeObservarEnLaTablaSoloLaInformacionDeEseEmpleado() {
        TableSearchPage tableSearchPage = new TableSearchPage(super.driver);
        String[] valoresEsperados = {"Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance"};
        try {
            Assertions.assertArrayEquals(valoresEsperados, tableSearchPage.getDataFromTableFromFirst());
            System.out.println("Assertion succesfull");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDriver();
        }
    }

}
