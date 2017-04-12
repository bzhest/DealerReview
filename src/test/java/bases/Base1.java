package bases;


import com.example.managers.ApplicationManager;
import dms.DmsLoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import page.Page;
import settings.Website;
import utility.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class Base1 {
    //Чтобы работать с ConfigurationManager - в Base1 должна быть ссылка на ApplicationManager
    public ConfigurationManager manager;
    public Logger logger;
    protected WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();
    public DmsLoginForm dmsLoginForm;
    protected TestBrowser testBrowser;


    @BeforeSuite
    public void turnOnMap2() throws InterruptedException {
        //logger.log("Navigating to test url");
        manager = ConfigurationManager.getInstance();

        System.setProperty("webdriver.chrome.driver", "E://Selenium_Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.get(PropertyLoader.loadProperty("dms.url"));
        driver.get("http://www.solomia.andreyb.ixloo.com/dms");
        //driver.findElement(By.cssSelector("#login")).clear();
        //driver.findElement(By.cssSelector("#login")).sendKeys("Hello");
        manager.getDmsLoginForm().loginToDMSUnderSupervisor();
        manager.getDmsMainPage().clickOnUsersMenu();
        manager.getUsers().openUserEditor();
        manager.getUserEditor().turnOnMAP2();
        manager.getWebsite().clickOnWebsiteMenu();
        manager.getWebsite().disableCaptcha();
        manager.getWebsite().setjQueryVersion();

    }

    @BeforeClass
    public void setUp() {
        logger = new Logger();

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "E://Selenium_Drivers/chromedriver.exe");
        driver.get("http://www.google.com");
        logger.log("Create singleton");
        manager = ConfigurationManager.getInstance();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        logger.log("Close browser");
        //ApplicationManager.getInstance().stop();

    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 35);
    /*method for execute Java Script: page should be loaded*/
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }
}
