package com.sofka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class FormPage extends CommonActionOnPage{


//localizadores
    @CacheLookup
    @FindBy(id = "email-2f43ffac-47f3-4c63-a0ac-b1cd28f3bedd")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "firstname-2f43ffac-47f3-4c63-a0ac-b1cd28f3bedd")
    private WebElement firstname;

    @CacheLookup
    @FindBy(id = "lastname-2f43ffac-47f3-4c63-a0ac-b1cd28f3bedd")
    private WebElement lastname;

    @CacheLookup
    @FindBy(id = "company-2f43ffac-47f3-4c63-a0ac-b1cd28f3bedd")
    private WebElement compania;

    @CacheLookup
    @FindBy(id = "phone-2f43ffac-47f3-4c63-a0ac-b1cd28f3bedd")
    private WebElement celular;

    @CacheLookup
    @FindBy(xpath = "(//option[@value='United States'])[1]")
    private WebElement pais;

    @CacheLookup
    @FindBy(id = "comments-2f43ffac-47f3-4c63-a0ac-b1cd28f3bedd")
    private WebElement comentarios;

    @CacheLookup
    @FindBy()

}
