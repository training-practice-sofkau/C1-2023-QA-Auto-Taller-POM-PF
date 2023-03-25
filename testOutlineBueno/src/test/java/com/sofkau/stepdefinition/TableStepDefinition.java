package com.sofkau.stepdefinition;
import com.sofkau.page.FormPage;
import com.sofkau.setup.WebUI;
import org.apache.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class TableStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(TableStepDefinition.class));
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion");
    }
    @When("navega hasta la opcion de webTables")
    public void navegaHastaLaOpcionDeWebTables() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickForm();
    }
    @When("completa la informacion el primer nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaLaInformacionElPrimerNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String string, String string2, String int1, String string3, String int2, String string4) {
        FormPage formPage=new FormPage(super.driver);
        formPage.fillMandatoryFields(string,string2,int1,string3,int2,string4);
    }
    @Then("debe observar la tabla con la informacion ingresada")
    public void debeObservarLaTablaConLaInformacionIngresada() throws InterruptedException {
        Thread.sleep(2000);
        quitDriver();
        LOGGER.info("|Esperado|Real|Valor|");
        for(int i=0;i<6;i++){
            Assertions.assertEquals(FormPage.esperados.get(i),FormPage.obtenidos.get(i));
            if(FormPage.esperados.get(i).equalsIgnoreCase(FormPage.obtenidos.get(i)))
                LOGGER.info(FormPage.esperados.get(i)+"|"+FormPage.obtenidos.get(i)+"|"+"cumple");
            else
                LOGGER.info(FormPage.esperados.get(i)+"|"+FormPage.obtenidos.get(i)+"|"+"no cumple");
        }
        FormPage.esperados.clear();
        FormPage.obtenidos.clear();
    }
}
