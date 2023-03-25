package com.sofkau.stepdefinitions;



import com.sofkau.pages.TablaPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class TablaStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(TablaStepDefinition.class);

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.warn("Inicio de la Automatizacion");

    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() throws InterruptedException {
        TablaPage tablaPage = new TablaPage(super.driver);
            tablaPage.Inicio();

    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(
            String nombre, String apellido, String edad, String email, String salario, String departamento) {
        TablaPage tablaPage =new TablaPage(super.driver);
        tablaPage.fillMandatoryFields(nombre,apellido,edad,email,salario,departamento);

    }
    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() throws InterruptedException {

        try {
            Assertions.assertEquals(TablaPage.informacion_ingresados,TablaPage.informacion_table);
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
        }finally {
            Thread.sleep(2000);
            quiteDriver();
        }

    }


}
