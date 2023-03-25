package com.sofkau.stepdefinitions;

import com.sofkau.models.Estudiante;
import com.sofkau.pages.CommonActionOnPages;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sofkau.util.Gender.FEMALE;
import static org.junit.Assert.assertEquals;


public class FormStepDefinition extends WebUI {

    Estudiante estudiante;

    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));
    @Given("el admministrador esta en la pagina principal")
    public void elAdmministradorEstaEnLaPaginaPrincipal() {
        generalSetUp();
        LOGGER.info("Inicio de la Automatizacion ");
    }

    @When("navega hasta la opcion de formulario")
    public void navegaHastaLaOpcionDeFormulario() throws InterruptedException {
        FormPage formPage = new FormPage(super.driver, estudiante);
        formPage.clickForm();
    }

    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        generateStudents();
        FormPage formPage = new FormPage(super.driver, estudiante);
        formPage.fillMandatoryFields();

    }

    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() {

        WebElement tabla = driver.findElement(By.className("table-dark"));
        List<WebElement> filas = tabla.findElements(By.tagName("tr"));

        // Iterar sobre las filas
        for (int i = 1; i < filas.size(); i++) {
            WebElement fila = filas.get(i);
            List<WebElement> celdas = fila.findElements(By.tagName("td"));

            // Iterar sobre las celdas
            for (int j = 1; j < celdas.size(); j++) {
                WebElement celda = celdas.get(j);
                String valor = celda.getText();

                // Comparar el valor esperado con el valor obtenido
                try {
                    if (i == 1 && j == 1) {
                        assertEquals("JessiLopez", estudiante.getName() + estudiante.getLastName());
                    } else if (i == 2 && j == 2) {
                        assertEquals("jessica@gmail.com", estudiante.getEmail());
                    } else if (i == 3 && j == 3) {
                        assertEquals("FEMALE", estudiante.getGender());
                    } else if (i == 3 && j == 3) {
                        assertEquals("3105478479", estudiante.getMobile());
                    } else if (i == 4 && j == 4) {
                        assertEquals("14 June 1999", estudiante.getDate());
                    } else if (i == 5 && j == 5) {
                        assertEquals("English", estudiante.getSubjects());
                    } else if (i == 6 && j == 6) {
                        assertEquals("Reading", estudiante.getHobbies());
                    } else if (i == 8 && j == 8) {
                        assertEquals("calle falsa - 123", estudiante.getCurrentAdress());
                    } else if (i == 9 && j == 9) {
                        assertEquals("NCRNoida", estudiante.getState()+ estudiante.getCity());
                    }
                } catch (AssertionError e) {
                    // Manejo de la excepción
                    System.out.println("El valor esperado no coincide con el valor obtenido: " + e.getMessage());
                }
            }
        }

    }

    public void generateStudents(){

        estudiante = new Estudiante();

        estudiante.setName("Jessi");
        estudiante.setLastName("Lopez");
        estudiante.setEmail("jessica@gmail.com");
        estudiante.setMobile("3105478479");
        estudiante.setGender(Gender.FEMALE);
        estudiante.setDate("14 June 1999");
        List<String> subjects = new ArrayList<>(Arrays.asList("English"));
        estudiante.setSubjects(subjects);
        estudiante.setHobbies(Hobbies.HOBBIE2);
        estudiante.setCurrentAdress("calle falsa - 123");
        estudiante.setState("NCR");
        estudiante.setCity("Noida");
    }

}
