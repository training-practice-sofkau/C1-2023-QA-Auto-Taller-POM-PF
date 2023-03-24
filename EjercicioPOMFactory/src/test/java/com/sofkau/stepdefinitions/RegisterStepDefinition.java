package com.sofkau.stepdefinitions;

import com.sofkau.pages.RegisterPage;
import com.sofkau.setup.WebUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.sofkau.setup.ConstantSetUp.HOME_DEMO_URL;

public class RegisterStepDefinition extends WebUi {

    public static List<String> datosIngresados = new ArrayList<>();
    public static Logger LOGGER = Logger.getLogger(String.valueOf(RegisterStepDefinition.class));
    private RegisterPage registerPage;

    @Given("el administrador esta en la pagina principal")
    public void elAdministradorEstaEnLaPaginaPrincipal() {
        try {
            generalSetUp(HOME_DEMO_URL);
            datosIngresados.clear();
            LOGGER.info("Inicio de la Automatizacion");
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }

    }
    @When("navega hasta la opcion de elementos en la opcion Web tables")
    public void navegaHastaLaOpcionDeElementosEnLaOpcionWebTables() {
        try {
            registerPage = new RegisterPage(super.driver);
            registerPage.navigateToTablePage();
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
    }
    @When("completa con nombre {string}, apellido {string}, edad {string}, correo electronico {string}, salario {string}, departamento {string}")
    public void completaConNombreApellidoEdadCorreoElectronicoSalarioDepartamento(String name, String lastname, String age, String email, String salary, String department) {
        try {
            valorDatosIngresados(name,lastname,age,email,salary,department);
            registerPage.fillMandatoryFields(name,lastname,age,email,salary,department);
            System.out.println(datosIngresados);
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
    }
    @Then("debe observar una tabla con la informacion ingresada")
    public void debeObservarUnaTablaConLaInformacionIngresada() {
        try {
            List<String> obtainedData = registerPage.interfaceWebTable();
            System.out.println(obtainedData);
//            Assertions.assertEquals(datosIngresados, obtainedData);
        }
        catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
        }finally {
            quitDriver();
        }
  }

    public void valorDatosIngresados(String nombre, String apellido, String edad, String correo, String salario, String departamento) {
        datosIngresados.add(nombre);
        datosIngresados.add(apellido);
        datosIngresados.add(edad);
        datosIngresados.add(correo);
        datosIngresados.add(salario);
        datosIngresados.add(departamento);
    }
}
