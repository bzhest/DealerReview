package utilityProject.browser.users;

import org.openqa.selenium.WebDriver;
import utilityProject.browser.api.WebDriverFactory;
import utilityProject.browser.api.WebDriverManager;
import utilityProject.configMan.ConfigurationManager;

import utilityProject.browser.enums.RunOn;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class DefaultWebDriverManager implements WebDriverManager {
    @Override
    public WebDriver getWebDriver() {
        //String runOn = ConfigurationManager.getInstance().getRunOn().toUpperCase();
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
