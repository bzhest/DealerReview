package utility.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
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

}
