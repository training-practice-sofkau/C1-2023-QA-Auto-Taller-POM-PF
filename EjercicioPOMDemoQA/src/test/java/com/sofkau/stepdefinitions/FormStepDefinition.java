package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FormStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(FormStepDefinition.class);
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("  inicio de la automatizacion");

    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() {
        FormPage formPage= new FormPage(super.driver);



    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        FormPage formPage= new FormPage(super.driver);
        formPage.fillMandatoryFields();

    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada(){
        WebElement modalTitle = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
        String expectedText = "Thanks for submitting the form";
        String actualText = modalTitle.getText();
        assertEquals(expectedText, actualText);
        LOGGER.info("El mensaje esperado se muestra correctamente: " + actualText);
}
}