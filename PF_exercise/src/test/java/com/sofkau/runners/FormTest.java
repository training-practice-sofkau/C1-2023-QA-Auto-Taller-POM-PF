package com.sofkau.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //las opciones que me va a dar , las dara como camelcase. El interpreta y lo trasnforma a CamelCase
        features = {"src/test/resources/features/practiceform.feature"},
        //le paso la ruta de donde esta mi feature
        publish = true,
        glue = {"com.sofkau.stepdefinitions"}
        //necesita saber ese feature donde va a correr esas funciones
)
public class FormTest {
}
