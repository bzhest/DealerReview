package utility.browser;

import org.openqa.selenium.WebDriver;
import utility.ConfigurationManager;

/**
 * Created by SYSTEM on 24.04.2017.
 */
public class LocalWebDriverFactory implements WebDriverFactory{
    @Override
    public String create() {
        String browserType= ConfigurationManager.getInstance().getTestBrowser().toUpperCase();
        switch(browserType){
            case "CHROME":
                return "Local Google Chrome";
            case "MOZILLA":
                return "Local Mozilla FireFox";
            case "SAFARI":
                return "Local Safari";
            default:
                return "Such browser is not supported";
        }
    }
}

