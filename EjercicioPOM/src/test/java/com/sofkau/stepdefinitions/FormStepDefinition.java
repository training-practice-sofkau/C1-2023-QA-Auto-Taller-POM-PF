package com.sofkau.stepdefinitions;

import com.sofkau.Repository;
import com.sofkau.models.Estudiante;
import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static com.sofkau.setup.ConstantSetup.*;


public class FormStepDefinition extends WebUi {
    Repository repository = new Repository();
    public static Logger LOGGER = Logger.getLogger(String.valueOf(FormStepDefinition.class));
    private FormPage formPage;
    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        generalSetUp(HOME_DEMO_URL);
        LOGGER.info("Inicio de la Automatizacion");
    }
    @When("navega hasta la opcion de formularios")
    public void navegaHastaLaOpcionDeFormularios() {
        formPage = new FormPage(super.driver, repository.generateStudent());
        formPage.goToForm();
    }
    @When("completa los campos con la informacion del estudiante")
    public void completaLosCamposConLaInformacionDelEstudiante() {
           formPage.fillMandatoryFields();
    }
    @Then("debe observar una ventana con la informacion ingresada")
    public void debeObservarUnaVentanaConLaInformacionIngresada() {

            List<String> obtained= obtainedResults();
            List<String> expected = Arrays.asList("Mariana","j.cardona1@gmail.com","Male","3215854785","20 February,2020","Maths, Arts","Sports, Music"
                    ,"Calle 32 no 4-51","NCR Delhi");
            System.out.println(obtained.size());

            try {
                Assertions.assertEquals(expected,obtained);
            }catch (Exception e){
                LOGGER.warning(e.getMessage());
                Assertions.fail();
            }finally {
                quitDriver();
            }
    }


    public List<String> obtainedResults(){
        List<String> values = new ArrayList<>();
        WebElement table = driver.findElement(By.xpath("//table/tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement fila : rows) {
            List<WebElement> cells = fila.findElements(By.tagName("td"));
            for (WebElement celda : cells) {
                values.add(celda.getText());
            }
        }
        values.toArray(new String[0]);
        List <String> compareValues = Arrays.asList(values.get(1),values.get(3),values.get(5),values.get(7),values.get(9),
                values.get(11),values.get(13),values.get(17),values.get(19));
        System.out.println(compareValues);
        return compareValues;

    }
}
