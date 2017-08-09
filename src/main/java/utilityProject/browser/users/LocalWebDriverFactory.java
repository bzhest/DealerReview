package utilityProject.browser.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilityProject.browser.api.WebDriverFactory;
import utilityProject.configMan.ConfigurationManager;

import utilityProject.browser.enums.BrowserType;
import utilityProject.browser.capabilities.DriverCapabilities;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class LocalWebDriverFactory implements WebDriverFactory {
    @Override
    public WebDriver create() {
        //String browserType= ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        //BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
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

