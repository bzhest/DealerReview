package utility.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.config.ConfigurationManager;
import utility.browser.enums.BrowserType;
import utility.capabilities.DriverCapabilities;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class BuildServerWebDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver create() {
        BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());

        switch (browserType) {
            case CHROME:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            case MOZILLA:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            case SAFARI:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            case IE:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            default:
                throw new RuntimeException();
        }
    }
}
