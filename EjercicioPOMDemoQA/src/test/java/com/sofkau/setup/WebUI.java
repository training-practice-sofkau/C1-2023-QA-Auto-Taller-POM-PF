package com.sofkau.setup;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.*;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {

    protected WebDriver driver;
    private void setUpWebdriverUrl() {
        driver=new ChromeDriver();
        driver.get(DEMO_QA_URL);
        maximize();

    }
    protected void generalSetUp(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }
    private void setUpWebdriver(){
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.edgedriver().setup();
    }
    protected void quiteDriver(){
        driver.quit();
    }
    private void maximize(){
        driver.manage().window().maximize();
    }
    public void zoom(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.body.style.zoom='75%'");
    }
    public void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
