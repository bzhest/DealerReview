package utility.browser.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.config.ConfigurationManager;
<<<<<<< HEAD:src/main/java/utility/browser/CloudWebDriverFactory.java
=======
import utility.browser.api.WebDriverFactory;
>>>>>>> d31912660906abf51d621e5561c99843aa6c168d:src/main/java/utility/browser/users/CloudWebDriverFactory.java
import utility.browser.enums.BrowserType;
import utility.capabilities.DriverCapabilities;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class CloudWebDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver create() {
        BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());

        switch(browserType){
            case CHROME:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            case MOZILLA:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            case SAFARI:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            case IE:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            default:
                throw  new RuntimeException();
        }
    }
}
