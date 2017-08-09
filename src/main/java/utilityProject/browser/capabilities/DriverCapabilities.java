package utilityProject.browser.capabilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilityProject.configMan.ConfigurationManager;
import utilityProject.browser.enums.BrowserType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DWork on 12.06.2017.
 */
public class DriverCapabilities {
    private static BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static Capabilities applyBrowserCapabilities(){

        switch(browserType){
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_settings.popups", 0);
                options.addArguments("disable-extensions");
                prefs.put("credentials_enable_service", false);
                prefs.put("password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("chrome.switches","--disable-extensions");
                options.addArguments("--test-type");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                capabilities.setCapability("webStorageEnabled",false);

                break;
            case MOZILLA:
                capabilities.setCapability("webStorageEnabled",false);
                break;
            case SAFARI:
                capabilities.setCapability("webStorageEnabled",false);
                break;
            case IE:
                capabilities.setCapability("webStorageEnabled",false);
                break;

        }
        return capabilities;
    }

}
