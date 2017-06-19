package utility.browser.api;

import org.openqa.selenium.WebDriver;

/**
 * Created by SYSTEM on 03.05.2017.
 */
public interface WebDriverManager {
    WebDriver getWebDriver();
    void destroyWebDriver(String driver);
}
