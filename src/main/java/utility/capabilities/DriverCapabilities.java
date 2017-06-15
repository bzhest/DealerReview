package utility.capabilities;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import utility.ConfigurationManager;
import utility.browser.enums.BrowserType;

/**
 * Created by DWork on 12.06.2017.
 */
public class DriverCapabilities {
    private static BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    public static Capabilities applyBrowserCapabilities(){

        switch(browserType){
            case CHROME:
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
