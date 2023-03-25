package com.sofkau.stepdefinitions;
import com.sofkau.page.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class FormStepDefinition extends WebUI {
    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));
    @Given("el administrador esta en la pagina principal")
    public void elAdmministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion");
    }

    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormulario() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickForm();
    }

    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante(){
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields();
    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException {
        Thread.sleep(2000);
        quitDriver();
        LOGGER.info("|Esperado|Real|Valor|");
        for(int i=0;i<9;i++){
            Assertions.assertEquals(FormPage.esperados.get(i),FormPage.obtenidos.get(i));
            if(FormPage.esperados.get(i).equalsIgnoreCase(FormPage.obtenidos.get(i)))
                LOGGER.info(FormPage.esperados.get(i)+"|"+FormPage.obtenidos.get(i)+"|"+"cumple");
            else
                LOGGER.info(FormPage.esperados.get(i)+"|"+FormPage.obtenidos.get(i)+"|"+"no cumple");
        }
    }
}