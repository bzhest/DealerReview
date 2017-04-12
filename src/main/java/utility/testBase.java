package utility;

import org.testng.annotations.Test;

/**
 * Created by SYSTEM on 12.04.2017.
 */
public class TestBase {
    protected Logger logger;
    protected TestBrowser testBrowser;

    public void setUp() {
        logger = new Logger();
        testBrowser = new TestBrowser();

        logger.log("Start browser" + testBrowser.create());
        String browser = testBrowser.create();

        beforeTest();
    }
        public void tearDown(){
        afterTest();
        testBrowser.destroy("");
    }
    protected void beforeTest(){};
    protected void afterTest(){};
    }

