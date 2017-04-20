package bases;


import com.example.logHelper.LogBase;
import com.example.managers.ApplicationManager;
import dms.DmsLoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utility.ConfigurationManager;
import page.Page;
import settings.Website;
import utility.*;
import utility.logger.LogBaseNew;

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
    //protected LogBaseNew logger = manager.getLogger(manager.getLoggerFromEnv());



    @BeforeSuite
    public void turnOnMap2() throws InterruptedException {
        //logger.log("Navigating to test url");
        System.setProperty("webdriver.chrome.driver", "E://Selenium_Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://www.solomia.andreyb.ixloo.com/dms");
        manager = ConfigurationManager.getInstance(driver);

        manager.getDmsLoginForm(driver).loginToDMSUnderSupervisor();
        manager.getDmsMainPage(driver).clickOnUsersMenu();
        manager.getUsers(driver).openUserEditor();
        manager.getUserEditor(driver).turnOnMAP2();
        manager.getWebsite(driver).clickOnWebsiteMenu();
        manager.getWebsite(driver).disableCaptcha();
        manager.getWebsite(driver).setjQueryVersion();

    }

    @BeforeClass
    public void setUp() {
        /*logger = new Logger();

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "E://Selenium_Drivers/chromedriver.exe");
        driver.get("http://www.google.com");
        logger.log("Create singleton");
        manager = ConfigurationManager.getInstance();*/
    }



    @AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        //ConfigurationManager.getInstance(driver).stop();

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
