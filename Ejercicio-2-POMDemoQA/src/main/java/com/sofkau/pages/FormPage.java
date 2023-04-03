package com.sofkau.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends CommonActionOnPages {

    @CacheLookup
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    private WebElement BOTON_ELEMENT;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Web Tables']")
    private WebElement BOTON_WEBTABLE;

    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement BOTON_ADD;
    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement CAJON_FIRST_NAME;
    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement CAJON_LAST_NAME;
    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement CAJON_EMAIL;
    @CacheLookup
    @FindBy(id = "age")
    private WebElement CAJON_AGE;
    @CacheLookup
    @FindBy(id = "salary")
    private WebElement CAJON_SALARY;
    @CacheLookup
    @FindBy(id = "department")
    private WebElement CAJON_DEPARTMENT;
    @CacheLookup
    @FindBy(id = "submit")
    private WebElement BOTON_SUBMIT;

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navegando() throws InterruptedException {
        scrollToElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]"));
        click(BOTON_ELEMENT);
        Thread.sleep(2000);
        scrollToElement(By.xpath("(//span[text()='Web Tables'])"));
        click(BOTON_WEBTABLE);
    }

    public void fillMandatoryFields(String firstname, String lastName, String email, String age, String salary, String department) {
        click(BOTON_ADD);
        this.CAJON_FIRST_NAME.sendKeys(firstname);
        this.CAJON_LAST_NAME.sendKeys(lastName);
        this.CAJON_EMAIL.sendKeys(email);
        this.CAJON_AGE.sendKeys(age);
        this.CAJON_SALARY.sendKeys(salary);
        this.CAJON_DEPARTMENT.sendKeys(department);
        click(BOTON_SUBMIT);
    }

    public boolean isButtonPresent() {
        By locator = By.xpath("(//*[name()='svg'][@stroke='currentColor'])[53]");
        try {
            FormPage formPage = new FormPage(super.driver);
            WebElement button = driver.findElement(locator);
            return button.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}