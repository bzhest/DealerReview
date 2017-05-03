package utility.browser;

import utility.ConfigurationManager;
import utility.browser.enums.BrowserType;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class BuildServerWebDriverFactory implements WebDriverFactory {
    @Override
    public String create() {
        //String browserType = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        BrowserType browserType = BrowserType.valueOf(ConfigurationManager.getInstance().getTestBrowser().toUpperCase());

        switch(browserType){
            case CHROME:
                return "Server Google Chrome";
            case MOZILLA:
                return "Server Mozilla FireFox";
            case SAFARI:
                return "Server Safari";
            case IE:
                return "Local IE";
            default:
                return "Such browser is not supported";
        }
    }
}
