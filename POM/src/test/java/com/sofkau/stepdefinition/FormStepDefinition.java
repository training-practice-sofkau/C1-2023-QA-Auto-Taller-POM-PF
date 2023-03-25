package com.sofkau.stepdefinition;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class FormStepDefinition extends WebUI {



    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la automatizacion");
    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver);
        formPage.practiceForm();
    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields();
    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() {
        FormPage formPage = new FormPage(super.driver);
        try {
            Assertions.assertEquals("Efrain Solorzano",formPage.assertionName());
            LOGGER.info(formPage.assertionName() + " = Efrain Solorzano"  );
            Assertions.assertEquals("efsolora@gmail.com",formPage.assertionEmail());
            LOGGER.info(formPage.assertionName() + " = Efsolora@gmail.com"  );
            Assertions.assertEquals("3243242342",formPage.assertionPhone());
            LOGGER.info(formPage.assertionName() + " =  3243242342"  );
            Assertions.assertEquals("cr50",formPage.assertionAddres());
            LOGGER.info(formPage.assertionName() + " =  cr50"  );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitDriver();
        }
        quitDriver();

    }
}
