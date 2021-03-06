package com.example.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 17.01.2017.
 */
public class WebDriverHelper {

    public WebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private ApplicationManager manager;

    public WebDriverHelper(ApplicationManager manager){
        this.manager = manager;
        System.setProperty("webdriver.chrome.driver", "E://Selenium_Drivers/chromedriver-2.5.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        baseUrl = "http://www.solomia.andreyb.ixloo.com/";
        wait = new WebDriverWait(driver,5);
        driver.get("http://www.solomia.andreyb.ixloo.com/");

    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
