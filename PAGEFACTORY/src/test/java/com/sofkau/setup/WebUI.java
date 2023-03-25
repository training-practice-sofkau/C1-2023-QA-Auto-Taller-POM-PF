package com.sofkau.setup;

import com.sofkau.util.Usuario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.sofkau.setup.ConstantSetup.DEMO_QA_URL;
import static com.sofkau.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class WebUI  {
    protected WebDriver driver;



    private void setupWebDriverUrl() {
        //driver = new ChromeDriver();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.get(DEMO_QA_URL);
        maximize();
    }

    protected  void generalSetUp() {
        setUplog4jUrl();
        setupWebDriverUrl();
        setUpWebDriver();
    }



    private void setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty(WEBDRIVER_CHROME_DRIVE,WEBDRIVER_CHROME_DRIVER_PATH );
    }

    private void setUplog4jUrl() {
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue() );
    }

    protected  void quitDriver() {
        driver.quit();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

}
