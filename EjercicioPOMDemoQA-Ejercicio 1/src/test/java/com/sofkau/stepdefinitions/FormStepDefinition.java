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
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormStepDefinition extends WebUI {

    public static Logger LOGGER= Logger.getLogger(FormStepDefinition.class);

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetup();
        LOGGER.info("Inicio de la automatizacion");
    }
    @When("navega hasta la opcion formularios")
    public void navegaHastaLaOpcionFormularios() {
        FormPage formPage = new FormPage(super.driver);
        formPage.navigateToForm();
    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
        FormPage formPage = new FormPage(super.driver);
        Estudiante estudiante = new Estudiante("Jose", "nunez",
                "nunez@gmail.com", Gender.MALE, "1234567891",
                "24 Nov 2000", Arrays.asList("Maths", "Chemistry"), Hobbies.SPORTS, "Cr 140 #120a-60",
                "NCR","Delhi");
        formPage.fillMandatoryFields(estudiante);
    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() throws InterruptedException{

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

        String[] expectedValues = {"Jose nunez", "nunez@gmail.com",
                "Male", "1234567891", "24 November,2000", "Maths, Chemistry",
                "Sports", "", "Cr 140 #120a-60", "NCR Delhi"};

        String[] actualValues = values.toArray(new String[0]);

        try{
            Assertions.assertArrayEquals(expectedValues,actualValues);
        } catch (Exception e){
            LOGGER.warn(e.getMessage());
            Assertions.fail();
        } finally {
            quiteDriver();
        }
    }
}
