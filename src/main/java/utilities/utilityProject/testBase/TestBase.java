package utilities.utilityProject.testBase;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.utilityProject.browser.api.WebDriverManager;
import utilities.utilityProject.browser.users.DefaultWebDriverManager;
import utilities.utilityProject.configMan.ConfigurationManager;
import utilities.utilityHelpers.logger.StdLogger;
import utilities.utilityHelpers.logger.api.LogBaseNew;
import utilities.utilityHelpers.windowHandlers.WindowHandlers;

/**
 * Created by Andrey on 06.04.2017.
 */
@Getter
public class TestBase {

    protected static LogBaseNew logger;
    protected static WebDriverManager wdm;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static ConfigurationManager manager;
    protected static WindowHandlers winHand;




    @BeforeSuite
    public void setUp() {
        logger = new StdLogger();
        wdm = new DefaultWebDriverManager();
        driver = wdm.getWebDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 25);
        manager = ConfigurationManager.getInstance(driver);
        winHand = new WindowHandlers(driver);


        beforeTest();
    }

    @AfterClass
    public void postconditions(){
        afterClass();
        //winHand.closeExtraWindows();
        //winHand.switchToParentWindow();

    }

    @AfterSuite
    public void tearDown() {
        wdm.destroyWebDriver(driver);
        afterSuite();
    }

    protected void beforeTest() {
    }
    protected void afterSuite() {
    }
    protected void afterClass(){

    }

    /*public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 35);
    *//*method for execute Java Script: page should be loaded*//*
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
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }*/
    public void sleep (Integer sec){
        try{
            Thread.sleep(1000 * sec);
        }catch(Exception ex){
            throw new RuntimeException("Can't wait for you, time is running out");
        }
    }

}
