package com.sofkau.stepdefinitions;

import com.sofkau.models.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import com.sofkau.util.Gender;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(FormStepDefinition.class);
    Estudiante e;
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        try {
            generalSetUp();
            LOGGER.info("inicio de la automatizacion");
        } catch (Exception e) {
            LOGGER.error("Error al cargar la pagina principal: " + e.getMessage());
            throw e;
        }

    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() throws InterruptedException {
        try {
            FormPage formPage = new FormPage(super.driver, e);
            formPage.clickForm();
        } catch (Exception e) {
            LOGGER.error("Error al navegar hasta la opcion de formularios: " + e.getMessage());
            throw e;
        }

    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        try {
            informationStudents();
            FormPage formPage = new FormPage(super.driver, e);
            formPage.fillMandatoryFields();
        } catch (Exception e) {
            LOGGER.error("Error al completar los campos con la informacion del estudiante: " + e.getMessage());
            throw e;
        }

    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() {
        try {
            WebElement table = driver.findElement(By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']"));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            List<String> values = new ArrayList<String>();

            for (WebElement row : rows) {
                List<WebElement> cols = row.findElements(By.tagName("td"));
                if (cols.size() > 1) {
                    String value = cols.get(1).getText();
                    values.add(value);
                }
            }

            String[] valoresEsperados = {"Meli Meneses", "melimenesesacevedo@gmail.com",
                    "Female", "3127357861", "04 September,2002","Chemistry","Sports", "","calle 49#57a-109-copa",
                    "NCR Noida"};
            String[] valoresActuales = values.toArray(new String[0]);

            Assertions.assertArrayEquals(valoresEsperados, valoresActuales);
            LOGGER.info("Los valores esperados y los valores obtenidos son iguales: " + Arrays.toString(valoresEsperados));
        } catch (Exception e) {
            LOGGER.error("Error al observar la ventana con la informacion ingresada: " + e.getMessage());
            throw e;
        } finally {
            quiteDriver();
        }


    }

    public void informationStudents(){
        e= new Estudiante();

        e.setName("Meli");
        e.setSecondname("Meneses");
        e.setEmail("melimenesesacevedo@gmail.com");
        e.setGender(Gender.FEMALE);
        e.setMobile("3127357861");
        e.setDate("04 September,2002");
        e.setSubject("Chemistry");
        e.setCurrentAddres("calle 49#57a-109-copa");
        e.setState("NCR");
        e.setCity("Noida");


    }
}
