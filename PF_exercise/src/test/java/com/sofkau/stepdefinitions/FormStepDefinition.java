package com.sofkau.stepdefinitions;

import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormStepDefinition {
    @Given("el cliente esta en la pagina principal")
    public void elClienteEstaEnLaPaginaPrincipal() {

    }
    @When("navega hasta la opcion de partners en la opcion Become a Partners")
    public void navegaHastaLaOpcionDePartnersEnLaOpcionBecomeAPartners() {

    }
    @When("completa con email {string}, nombre {string}, apellido {string}, compania {string}, celular {string}, pais {string}, comentarios {string}")
    public void completaConEmailNombreApellidoCompaniaCelularPaisComentarios(String email, String nombre, String apellido, String compania, String celular, String pais, String comentarios) {
        System.out.println(email);
    }
    @Then("debe observar un mensaje en pantalla de envio exitoso")
    public void debeObservarUnMensajeEnPantallaDeEnvioExitoso() {

    }


}
