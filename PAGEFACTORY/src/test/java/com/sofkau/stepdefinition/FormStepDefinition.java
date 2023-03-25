package com.sofkau.stepdefinition;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class FormStepDefinition extends WebUI {


    FormPage formPage = new FormPage(super.driver);
    Usuario usuario = new Usuario("Efrain",
            "solorzano",
            "cr 40",
            "medellin",
            "dawd",
            "055420",
            "32432423423",
            "423423",
            "efr",
            "32432342",
            "32432342");

    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);
    @Given("el usuario esta en la pagina principal")
    public void elUsuarioEstaEnLaPaginaPrincipal() {
        generalSetUp();
    }
    @When("navega hasta la opcion de registro")
    public void navegaHastaLaOpcionDeRegistro() {
        FormPage formPage = new FormPage(super.driver);
        formPage.practiceForm();
    }
    @When("completa los campos con la informacion de usuario en {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void completaLosCamposConLaInformacionDeUsuarioEn(String firstName, String lastName, String adress, String city, String state, String zipcode, String phone, String cnn, String userName, String password, String repeatPassword) {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields(firstName,lastName,adress,city,state,zipcode,phone,cnn,userName,password,repeatPassword);
    }
    @Then("debe observar un mensaj que su cuenta fue creada")
    public void debeObservarUnMensajQueSuCuentaFueCreada() {
        FormPage formPage = new FormPage(super.driver);
        try {
            Assertions.assertEquals("Your account was created successfully. You are now logged in.",formPage.assertionMesage());
            LOGGER.info(formPage.assertionMesage() + " = Your account was created successfully. You are now logged in."  );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitDriver();
        }
        quitDriver();
    }
}
