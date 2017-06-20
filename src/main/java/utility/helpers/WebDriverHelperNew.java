package utility.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.config.ConfigurationManager;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 03.05.2017.
 */
public class WebDriverHelperNew {
    private ConfigurationManager manager;
    public WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();

    {
        /*driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Подождать 20 сек появления какого-то элемента
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
    }

    public WebDriverHelperNew(ConfigurationManager manager){
        this.manager = manager;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void stop(){
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
