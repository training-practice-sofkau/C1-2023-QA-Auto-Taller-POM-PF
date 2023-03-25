package com.sofkau.stepdefinitions;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));

    @Given("el administrador esta en la pagina principal")
    public void elAdmministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion ");
    }

    @When("navega hasta la opcion de formulario")
    public void navegaHastaLaOpcionDeFormulario() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.clickForm();
    }

    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields();
    }


    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException {

        List<String> obtained = obtainedResults();
        List<String> expected = Arrays.asList("James Muñoz", "jamb1993@gmail.com", "Male", "3148975672", "20 August,2000", "Chemistry", "Sports", "",
                "calle 34cc", "NCR Noida");
        try {
            Assertions.assertEquals(expected, obtained);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        } finally {
            Thread.sleep(5000);
            quiteDriver();
        }
    }
    private List<String> obtainedResults() {
        List<WebElement> resultElements = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
        List<String> results = new ArrayList<>();
        for (WebElement element : resultElements) {
            results.add(element.getText());
        }
        return results;
    }
}

