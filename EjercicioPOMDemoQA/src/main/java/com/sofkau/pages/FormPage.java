package com.sofkau.pages;

import com.sofkau.models.Estudiante;
import com.sofkau.util.Gender;
import com.sofkau.util.Hobbie;
import org.apache.pdfbox.contentstream.operator.state.Concatenate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.SX;

import java.util.ArrayList;
import java.util.List;

public class FormPage extends CommonActionOnPages{
    public static int prueba=0;

    private ArrayList<String> hobbies;
    private ArrayList<String> subjects;

    public static ArrayList<String> datosIngresados;
    public static ArrayList<String> datosTablas;
    Estudiante estudiante=new Estudiante("Ash","Ketchum","ashito@salsadetomate.com","Male","3132132323","1996","October",
            "13",subjects=new ArrayList<>(List.of("Maths","Arts")),hobbies=new ArrayList<>(List.of("Sports","Reading")),"","Pueblo Paleta calle falsa 123","NCR","Delhi");
    private final By iconoForms=By.xpath("//div[@class='card mt-4 top-card'][2]");
    private final By iconoPracticeForms=By.xpath("//*[text()='Practice Form']");
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.xpath("//*[text()='Male']");
    private final By genderFemale = By.xpath("//*[text()='Female']");
    private final By genderOther = By.xpath("//*[text()='Other']");
    private final By number = By.id("userNumber");
    private final By date=By.id("dateOfBirthInput");
    private final By monthCombobox = By.xpath("//*[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']");
    private final By month=By.xpath("//*[text()='"+estudiante.getMonth()+"']");
    private final By yearCombobox = By.xpath("//*[@class='react-datepicker__year-select']");
    private final By year=By.xpath("//*[text()='"+estudiante.getYear()+"']");
    private final By day=By.xpath("//*[text()='"+estudiante.getDay()+"']");
    private final By subject=By.id("subjectsInput");
    private final By sports=By.xpath("//*[text()='Sports']");
    private final By reading=By.xpath("//*[text()='Reading']");
    private final By music=By.xpath("//*[text()='Music']");
    private final By addres=By.id("currentAddress");
    private final By state=By.id("react-select-3-input");
    private final By city=By.id("react-select-4-input");
    private final By submit=By.id("submit");

    public FormPage(WebDriver driver) {
        super(driver);

    }
    public void navigatePage(){
        click(iconoForms);
        click(iconoPracticeForms);
    }
    public void fillMandatoryFields() throws InterruptedException {
        clearText(name);
        typeInto(name, estudiante.getName());
        typeInto(lastName, estudiante.getLastName());
        typeInto(email, estudiante.getEmail());
        seleccionarGender(estudiante);

        typeInto(number, estudiante.getMobile());
        click(date);
        click(monthCombobox);
        click(month);
        click(yearCombobox);
        click(year);
        click(yearCombobox);
        click(day);
        escribirSubjects(estudiante);
        seleccionarHobbies(estudiante);
        typeInto(addres, estudiante.getCurrentAddres());
        pressSpace(state);
        typeInto(state,estudiante.getState());
        pressEnter(state);
        pressSpace(city);
        typeInto(city,estudiante.getCity());
        pressEnter(city);
        pressEnter(submit);
        Thread.sleep(2000);
        datosIngresados= (ArrayList<String>) datosIngresados();
        datosTablas= (ArrayList<String>) crearLista();
    }

    public void comparar() throws InterruptedException {
        Thread.sleep(2000);
        List<String> datosTabla=new ArrayList<>();
        List<String> datosIngresados=new ArrayList<>();
        datosTabla=crearLista();
        datosIngresados=datosIngresados();

    }

    public List<String> crearLista(){
        List<String> lista=new ArrayList<>();
        lista.add(getText(By.xpath("//tbody/descendant::*[3]")));
        lista.add(getText(By.xpath("//tbody/descendant::*[6]")));
        lista.add(getText(By.xpath("//tbody/descendant::*[9]")));
        lista.add(getText(By.xpath("//tbody/descendant::*[12]")));
        return lista;
    }

    public List<String> datosIngresados(){
        List<String> lista=new ArrayList<>();
        lista.add(estudiante.getName()+" "+estudiante.getLastName());
        lista.add(estudiante.getEmail());
        lista.add(estudiante.getGender());
        lista.add(estudiante.getMobile());
        return lista;
    }
    public String compararSubjects(Estudiante estudiante){
        String subjects="";
        for(int i=0;i<estudiante.getSubject().size();i++){
            subjects=subjects+estudiante.getSubject().get(i);
            if(i<estudiante.getSubject().size()-1){
                subjects=subjects+", ";
            }
        }
        return subjects;
    }

    public void seleccionarGender(Estudiante estudiante){
        if(estudiante.getGender()=="Male"){
            click(genderMale);
        }else if(estudiante.getGender()=="Female"){
            click(genderFemale);
        }else{
            click(genderOther);
        }
    }

    public void seleccionarHobbies(Estudiante estudiante){
        for(int i=0;i<estudiante.getHobbies().size();i++){
            if(estudiante.getHobbies().get(i)=="Sports"){
                click(sports);
            } else if (estudiante.getHobbies().get(i)=="Reading") {
                click(reading);
            }else{
                click(music);
            }
        }
    }

    public void escribirSubjects(Estudiante estudiante){
        for(int i=0;i<estudiante.getSubject().size();i++){
            typeInto(subject, estudiante.getSubject().get(i));
            pressEnter(subject);
        }
    }
}
