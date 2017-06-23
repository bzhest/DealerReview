import org.openqa.selenium.WebDriver;
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


    public void setUp(){
        logger = new StdLogger(ConfigurationManager manager);
        wdm = new DefaultWebDriverManager();
        driver = wdm.getWebDriver();
        beforeTest();
    }

    public void tearDown(){
        afterTest();
    }

    protected void beforeTest(){}
    protected void afterTest(){}

}
