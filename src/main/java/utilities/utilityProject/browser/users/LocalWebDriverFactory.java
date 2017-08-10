package utilities.utilityProject.browser.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.utilityProject.browser.api.WebDriverFactory;
import utilities.utilityProject.configMan.ConfigurationManager;

import utilities.utilityProject.browser.enums.BrowserType;
import utilities.utilityProject.browser.capabilities.DriverCapabilities;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class LocalWebDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver create() {
        BrowserType browserType = BrowserType.fromString(ConfigurationManager.getInstance().getTestBrowser());
        switch(browserType){
            case CHROME:
                return new ChromeDriver(DriverCapabilities.applyBrowserCapabilities());
            case MOZILLA:
                return new FirefoxDriver(DriverCapabilities.applyBrowserCapabilities());
            case SAFARI:
                return new SafariDriver(DriverCapabilities.applyBrowserCapabilities());
            case IE:
                return new InternetExplorerDriver(DriverCapabilities.applyBrowserCapabilities());
            default:
                throw new RuntimeException();
        }

    }
}

