package bases;


import com.example.managers.ApplicationManager;
import dms.DmsLoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utility.ConfigurationManager;
import utility.Logger;
import utility.TestBrowser;

import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class Base1 {
    //Чтобы работать с ConfigurationManager - в Base1 должна быть ссылка на ApplicationManager
    public ConfigurationManager app;
    public Logger logger;
    protected WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();
    protected DmsLoginForm dmsLoginForm;
    protected TestBrowser testBrowser;

    @BeforeClass
    public void setUp() {
        logger = new Logger();

        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "E://Selenium_Drivers/chromedriver.exe");
        driver.get("http://www.google.com");
        logger.log("Create singleton");
        app = ConfigurationManager.getInstance();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        logger.log("Close browser");
        ApplicationManager.getInstance().stop();

    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
