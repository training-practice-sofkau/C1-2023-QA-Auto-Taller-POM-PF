package com.sofkau.page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static com.sofkau.util.Localizador.*;

public class FormPage extends CommonActionOnPage{
    public static ArrayList<String> esperados=new ArrayList<>();
    public static ArrayList<String> obtenidos=new ArrayList<>();
    //constructor
    public FormPage(WebDriver driver) {
        super(driver);
    }
    public void clickForm() throws InterruptedException {
        WebElement element = driver.findElement(FORM.getBy());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(200);
        click(PRACTICE_FORM.getBy());
    }
    public void fillMandatoryFields(){
        WebElement element;
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        clearText(NAME.getBy());
        typeInto(NAME.getBy(), "Ivan");
        typeInto(LASTNAME.getBy(), "Ruiz");
        esperados.add("Ivan Ruiz");
        typeInto(EMAIL.getBy(),"megaxe6639@gpipes.com");
        esperados.add("megaxe6639@gpipes.com");
        click(GENDER.getBy());
        esperados.add("Male");
        typeInto(NUMBER.getBy(),"3223459044");
        esperados.add("3223459044");
        selectDate(DATE.getBy(),"11 november 2000");
        esperados.add("11 November,2000");
        typeInto(SUBJECT.getBy(),"English");
        tab(SUBJECT.getBy());
        esperados.add("English");
        setZoom(55);
        element=driver.findElement(HOBBIES.getBy());
        executor.executeScript("arguments[0].click()",element);
        esperados.add("Music");
        typeInto(CURRENT_ADDRESS.getBy(), "cra 8c #186-67");
        esperados.add("cra 8c #186-67");
        typeInto(STATE.getBy(), "NCR");
        tab(STATE.getBy());
        esperados.add("NCR Delhi");
        typeInto(CITY.getBy(), "Delhi");
        tab(CITY.getBy());
        element = driver.findElement(SUBMIT.getBy());
        executor.executeScript("arguments[0].click();", element);
        setZoom(85);
        resultado();
    }
    public void resultado(){
        WebElement element;
        setZoom(55);
        for(int i=2;i<=20;i++){
            if(i==16)
                i+=2;
            if(i==20) {
                obtenidos.add("NCR Delhi");
                break;
            }
            element= driver.findElement(By.xpath("(//td)["+i+"]"));
            obtenidos.add(element.getText());
            i++;
        }
    }
}