package bases;


import utilities.utilityProject.testBase.TestBase;
import utilities.utilityProject.properties.PropertyLoader;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class Base1 extends TestBase {

    @Override
    protected void beforeTest() {
        logger.log("Navigating to test url");
        driver.manage().window().maximize();
        driver.get(PropertyLoader.loadProperty("dms.url"));
    }
}

