package com.sofkau.stepdefinitions;


import com.sofkau.pages.TableRegPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class TableStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(TableStepDefinition.class);
    private String[] valoresEsperados;
    @Given("el admin esta en la pagina principal")
    public void elAdminEstaEnLaPaginaPrincipal() {
        generalSetup();
        LOGGER.info("Inicio de la automatizacion");
    }
    @When("navega hasta la opcion webtable")
    public void navegaHastaLaOpcionWebtable() throws InterruptedException{
        try{
        TableRegPage tableRegPage = new TableRegPage(super.driver);
        tableRegPage.navigateToTable();
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }
    @When("da click en el boton add")
    public void daClickEnElBotonAdd() throws InterruptedException{
        try {
            TableRegPage tableRegPage = new TableRegPage(super.driver);
            tableRegPage.startNewRecord();
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }

    @When("completa los campos con la informacion del empleado nombre {string}, apellido {string}," +
            " edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaLosCamposConLaInformacionDelEmpleadoNombreApellidoEdadCorreoElectronicoSalarioDepartamento(
            String firstname, String lastname, String age, String email, String salary, String department)
            throws InterruptedException {
        try{
            TableRegPage tableRegPage = new TableRegPage(super.driver);
            tableRegPage.fillMandatory(firstname, lastname, email, age, salary, department);
            valoresEsperados = new String[]{firstname, lastname, age, email, salary, department};
        }catch (Exception e){
            LOGGER.warn(e.getMessage());
            quiteDriver();
        }
    }

    @Then("debe observar en la tabla la informacion ingresada")
    public void debeObservarEnLaTablaLaInformacionIngresada() {
        TableRegPage tableRegPage = new TableRegPage(super.driver);
        try {
            Assertions.assertArrayEquals(valoresEsperados, tableRegPage.getDataFromTable());
            System.out.println("Assertion succesfull");
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDriver();
        }
    }
}
