package utilities.utilityProject.browser.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.utilityProject.browser.api.WebDriverFactory;
import utilities.utilityProject.configMan.ConfigurationManager;

import utilities.utilityProject.browser.enums.BrowserType;
import utilities.utilityProject.browser.capabilities.DriverCapabilities;

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
