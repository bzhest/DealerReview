package utility.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utility.browser.api.WebDriverManager;
import utility.browser.users.DefaultWebDriverManager;
import utility.config.ConfigurationManager;
import utility.logger.StdLogger;
import utility.logger.api.LogBaseNew;

/**
 * Created by Andrey on 06.04.2017.
 */
public class TestBase {

    protected LogBaseNew logger;
    protected WebDriverManager wdm;
    protected WebDriver driver;


@BeforeSuite
    public void setUp(){
        logger = new StdLogger();
        wdm = new DefaultWebDriverManager();
        driver = wdm.getWebDriver();
        beforeTest();
    }

@AfterSuite
    public void tearDown(){
        wdm.destroyWebDriver(driver);
        afterTest();
    }

    protected void beforeTest(){}
    protected void afterTest(){}

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
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

}
