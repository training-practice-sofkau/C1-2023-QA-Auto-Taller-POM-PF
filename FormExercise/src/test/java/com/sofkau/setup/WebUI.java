package com.sofkau.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.sofkau.setup.SetUpConst.*;

public class WebUI {
    protected WebDriver driver;

    private void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
    }

    private void setUpWebDriverUrl() {
        driver.get(DEMO_QA_URL);
        maximize();
    }

    private void maximize() {
        driver.manage().window().maximize();
    }

    protected void generalSetUp() {
        setUpChromeDriver();
        setUpWebDriverUrl();
    }

    protected void quitDriver() {
        driver.quit();
    }
}
