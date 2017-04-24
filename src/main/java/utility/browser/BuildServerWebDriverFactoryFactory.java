package utility.browser;

import utility.ConfigurationManager;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class BuildServerWebDriverFactoryFactory implements WebDriverFactory {
    @Override
    public String create() {
        String browserType = ConfigurationManager.getInstance().getTestBrowser().toUpperCase();

        switch(browserType){
            case "CHROME":
                return "Server Google Chrome";
            case "MOZILLA":
                return "Server Mozilla FireFox";
            case "SAFARI":
                return "Server Safari";
            default:
                return "Such browser is not supported";
        }
    }
}
