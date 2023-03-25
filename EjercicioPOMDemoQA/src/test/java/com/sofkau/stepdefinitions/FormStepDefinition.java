package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.PracticeForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class FormStepDefinition extends WebUI {

    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores esperados y reales difieren";
    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("inicio de la automatizacion");
    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.toForm();
    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields();
    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException {
        Thread.sleep(10000);
        try {
            FormPage formPage = new FormPage(super.driver);
            PracticeForm practiceForm = new PracticeForm();
            practiceForm.fillStudentInfo();

            Assertions.assertEquals(
                    practiceForm.getStudent()
                            .getName() + " " + practiceForm.getStudent().getLastName(),
                    formPage.getStudentName()
            );
            Assertions.assertEquals(
                    practiceForm.getStudent()
                            .getEmail(),
                    formPage.getStudentEmail()
            );
            Assertions.assertNotNull(formPage.getConfirmationMessage());
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        } finally {
            driver.quit();
        }
    }


}
