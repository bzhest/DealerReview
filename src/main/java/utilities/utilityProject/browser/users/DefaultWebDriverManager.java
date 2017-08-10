package utilities.utilityProject.browser.users;

import org.openqa.selenium.WebDriver;
import utilities.utilityProject.browser.api.WebDriverFactory;
import utilities.utilityProject.browser.api.WebDriverManager;
import utilities.utilityProject.configMan.ConfigurationManager;

import utilities.utilityProject.browser.enums.RunOn;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class DefaultWebDriverManager implements WebDriverManager {
    @Override
    public WebDriver getWebDriver() {
        RunOn runOn = RunOn.fromString(ConfigurationManager.getInstance().getRunOn().toUpperCase());
        WebDriverFactory factory;

        switch(runOn){
            case LOCAL:
                factory = new LocalWebDriverFactory();
                break;
            case BUILDSERVER:
                factory = new BuildServerWebDriverFactory();
                break;
            case CLOUD:
                factory = new CloudWebDriverFactory();
                break;
            default:
                throw new RuntimeException();
        }
    return factory.create();
    }

    @Override
    public void destroyWebDriver(WebDriver driver) {
        if(driver !=null)
           driver.quit();
        System.out.println("Quit driver - " + driver);
    }
}
