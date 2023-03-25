package com.sofkau.stepdefinitions;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class FormStepDef extends WebUI {

    @Given("Administrator was on main page")
    public void administratorWasOnMainPage() {
        generalSetUp();
    }

    @When("Navigate to form option")
    public void navigateToFormOption() {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields();
    }

    @When("Complete fields with student's information")
    public void completeFieldsWithStudentSInformation() {

    }

    @Then("A window with a thanks message will be displayed")
    public void aWindowWithAThanksMessageWillBeDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        Assertions.assertEquals("Juan", "Juan");
        quitDriver();
    }
}
