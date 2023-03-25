package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.sofkau.setup.ConstantSetup.DEMO_QA_URL;
import static com.sofka.util.Log4j.LOG4J_PROPERTIES_FILE_PATH;

public class WebUI {
    protected WebDriver driver;

    private void setUpWebdriver(){
        WebDriverManager.chromedriver().setup();
    }

    private void setUpWebdriverUrl(){
        ChromeOptions chrop = new ChromeOptions();
        chrop.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chrop);
        driver.get(DEMO_QA_URL);
        maximize();
    }

    protected void generalSetup(){
        setUplog4j();
        setUpWebdriver();
        setUpWebdriverUrl();
    }

    protected void quiteDriver(){
        driver.quit();
    }

    private void maximize(){
        driver.manage().window().maximize();
    }

    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
