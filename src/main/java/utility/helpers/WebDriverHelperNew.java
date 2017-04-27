package utility.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigurationManager;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 20.04.2017.
 */
public class WebDriverHelperNew {
    private ConfigurationManager manager;
    private static WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();

    //non-static init (perform BEFORE constructor)
    {   driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    public WebDriverHelperNew(ConfigurationManager manager){
        this.manager = manager;
    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
