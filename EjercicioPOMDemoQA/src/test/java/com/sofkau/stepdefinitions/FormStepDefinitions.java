package com.sofkau.stepdefinitions;
import com.sofkau.models.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class FormStepDefinitions  extends WebUI {
    private Estudiante Santy;

    public static Logger LOGGER = Logger.getLogger (FormStepDefinitions.class);

    @Given("el adminsitrador esta en la pagina principal")
    public void elAdminsitradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        // Se debe crear cosntantes en mensajes , sin quemar valores en el codigo
        LOGGER.info("Por fin pude correr esto");


    }
    @When("navega hasta la opcion de formulario")
    public void navegaHastaLaOpcionDeFormulario()throws InterruptedException{
       FormPage formPage = new FormPage( super.driver, generateStudent());
         //formPage.FillMandatoryFields();
       // formPage.inicioPagina();


    }
    @When("completa los campos con  la informacion de un estudiante")
    public void completaLosCamposConLaInformacionDeUnEstudiante() {
        FormPage formPage = new FormPage(super.driver, Santy);
        formPage.FillMandatoryFields();

    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() {

    }


private Estudiante generateStudent(){
        Santy = new Estudiante();
        Santy.setName ("Santy");
        Santy.setLastName ("Ramirez");
        Santy.setEmail ("correofalso@gmail.com");
        Santy.setGender(Gender.MALE);
        Santy.setUserNumber("2309200010309383");
        // Arrays.asList es un método que convierte un conjunto de elementos en una lista
        Santy.setSubjects(Arrays.asList( "History"));
        Santy.setHobbies(Arrays.asList(Hobbies.READING, Hobbies.MUSIC, Hobbies.SPORTS));
        Santy.getPicture();
        Santy.setCity("Delhi");
        Santy.setState("NCR");
        Santy.setAdressUsuario("Calle 123");
        Santy.setDateofBirth("17/03/2023");
return  Santy;

}



}
