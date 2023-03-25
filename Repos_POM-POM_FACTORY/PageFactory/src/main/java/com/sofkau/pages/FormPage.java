package com.sofkau.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FormPage extends CommonActionOnPages {
    public static ArrayList<String> expected = new ArrayList<>();
    public static ArrayList<String> obtened = new ArrayList<>();
    @CacheLookup
    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[1]")
    private WebElement form;
    @CacheLookup
    @FindBy(xpath = "(//span[text()='Web Tables'])")
    private WebElement clickForm;
    @CacheLookup
    @FindBy(id = "firstName")
    private WebElement inputFirstName;
    @CacheLookup
    @FindBy(id = "lastName")
    private WebElement inputLastName;
    @CacheLookup
    @FindBy(id = "userEmail")
    private WebElement inputUserEmail;
    @CacheLookup
    @FindBy(id = "age")
    private WebElement inputAge;
    @CacheLookup
    @FindBy(id = "salary")
    private WebElement inputSalary;
    @CacheLookup
    @FindBy(id = "department")
    private WebElement inputDepartment;
    @CacheLookup
    @FindBy(id = "addNewRecordButton")
    private WebElement btnAdd;
    @CacheLookup
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement btnSubmit;

    //constructor
    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickForm() throws InterruptedException {
        click(form);
        Thread.sleep(2000);
        click(clickForm);

    }

    public void enviarDatosFormulario(String firstName, String lastName, String userEmail, String age, String salary, String department) {
        this.inputFirstName.sendKeys(firstName);
        expected.add(firstName);
        this.inputLastName.sendKeys(lastName);
        expected.add(lastName);
        this.inputUserEmail.sendKeys(userEmail);
        expected.add(age);
        this.inputAge.sendKeys(age);
        expected.add(userEmail);
        this.inputSalary.sendKeys(salary);
        expected.add(salary);
        this.inputDepartment.sendKeys(department);
        expected.add(department);
        clickBtnSubmitTabla();
        results();
    }

    public void clickBtnAddTabla() {
        this.btnAdd.click();
    }

    public void clickBtnSubmitTabla() {
        this.btnSubmit.click();
    }

    public List<String> results() {
        return IntStream.rangeClosed(22, 27)
                .mapToObj(i -> driver.findElement(By.xpath("(//div[@role='gridcell'])[" + i + "]")))
                .map(WebElement::getText)
                .peek(FormPage.obtened::add)
                .collect(Collectors.toList());
    }

}
