package com.sofkau.pages;

import com.sofkau.util.Usuario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends  CommonActionOnPages{

  @CacheLookup
  @FindBy(xpath = "//a[contains(text(),'Register')]")
  private WebElement register;

  @CacheLookup
  @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer.lastName")
    private WebElement lastname;

    @CacheLookup
    @FindBy(id = "customer.address.street")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "customer.address.city")
    private WebElement city;

    @CacheLookup
    @FindBy(id = "customer.address.state")
    private WebElement state;

    @CacheLookup
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @CacheLookup
    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;

    @CacheLookup
    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @CacheLookup
    @FindBy(id = "customer.username")
    private WebElement username;

    @CacheLookup
    @FindBy(id = "customer.password")
    private WebElement password;

  @CacheLookup
  @FindBy(id = "repeatedPassword")
  private WebElement repeatedPssword;

  @CacheLookup
  @FindBy(xpath = "//input[@value='Register']")
  private WebElement buttonRegister;

  @CacheLookup
  @FindBy(xpath = "(//p)[3]")
  private WebElement asserMessage;



    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void practiceForm() {
        click(register);
    };


    public void fillMandatoryFields(String firstName, String lastname, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String userName, String password, String repeatPassword) {
      typeInto(this.firstName,firstName);
      typeInto(this.lastname,lastname);
      typeInto(this.address,address);
      typeInto(this.city, city);
      typeInto(this.state,state);
      typeInto(this.zipCode,zipCode);
      typeInto(this.phoneNumber,phoneNumber);
      typeInto(this.ssn,ssn);
      typeInto(this.username,userName);
      typeInto(this.password,password);
      typeInto(this.repeatedPssword,repeatPassword);
      click(buttonRegister);

    }
  public String assertionMesage(){
    String ass = getText(asserMessage);
    return ass;
  }
}
