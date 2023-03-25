package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TableSearchPage extends CommonActionsOnPages{

    @CacheLookup
    @FindBy(xpath = "(//div[contains(@class, 'card mt-4 top-card')])[1]")
    private WebElement botonElement;

    @CacheLookup
    @FindBy(xpath = "(//li[@id='item-3'])[1]")
    private WebElement botonWebTable;

    @CacheLookup
    @FindBy(id = "searchBox")
    private WebElement fieldToSearch;

    @CacheLookup
    @FindBy(xpath = "(//div[@role='row'])[2]")
    private WebElement fila2;

    private By celdas = By.xpath(".//div[@role='gridcell']");

    public TableSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToTable(){
        click(botonElement);
        click(botonWebTable);
    }

    public void searchEmploy(String value){
        setZoom(80);
        typeInto(fieldToSearch, value);
        pressEnter(fieldToSearch);
    }

    public String[] getDataFromTableFromFirst(){
        WebElement fila = fila2;
        List<WebElement> campos = fila.findElements(celdas);
        String[] valores = new String[campos.size()-1];
        for (int i = 0; i < campos.size()-1; i++) {
            valores[i] = campos.get(i).getText();
        }
        return valores;
    }

}
