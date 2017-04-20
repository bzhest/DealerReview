package page;

import dms.DmsLoginForm;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import utility.ConfigurationManager;
import utility.LogFactory;



/**
 * Created by Andrey on 15.03.2017.
 */
public class Page{
    private static final Logger LOG = LogFactory.getLogger(Page.class);
    public Logger logger;
    public ConfigurationManager manager;
    protected WebDriver driver;



    public Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }



    public WebDriver getWebDriver() {
        return driver = new ChromeDriver();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        String pageUrl = driver.getCurrentUrl();
        LOG.info("Current page url is: " + pageUrl);
        return pageUrl;
    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
    /*method for execute Java Script: page should be loaded*/
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        // wait for jQuery to load
            ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public void inputText(WebElement webElement, String value){
        webElement.clear();
        webElement.sendKeys(value);
    }
}
