package utility.browser.users;

import org.openqa.selenium.WebDriver;
import utility.browser.api.WebDriverFactory;
import utility.browser.api.WebDriverManager;
import utility.config.ConfigurationManager;

import utility.browser.enums.RunOn;

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
        /*if(driver ==null)
           id driver.quit();*/
        System.out.println("Quit driver - " + driver);
    }
}
