package utility;

import org.testng.annotations.Test;
import utility.browser.DefaultWebDriverManager;
import utility.browser.WebDriverManager;

/**
 * Created by SYSTEM on 13.04.2017.
 */
public class TestBaseCourse {
    protected Logger logger;
    protected TestBrowser testBrowser;
    protected WebDriverManager wdm;

    public void setUp() {
        logger = new Logger();
        wdm = new DefaultWebDriverManager();

        logger.log("Start browser" + wdm.getWebDriver());
        String browser = testBrowser.create();

        beforeTest();
    }
    public void tearDown(){
        afterTest();
        testBrowser.destroy("");
    }
    protected void beforeTest(){}
    protected void afterTest(){}
}