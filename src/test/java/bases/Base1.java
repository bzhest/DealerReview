package bases;


import dms.DmsLoginForm;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import settings.Users;
import utility.browser.users.DefaultWebDriverManager;
import utility.config.ConfigurationManager;
import utility.browser.users.LocalWebDriverFactory;
import utility.browser.api.WebDriverManager;
import utility.data.User;
import utility.logger.api.LogBaseNew;
import utility.properties.PropertyLoader;
import utility.utils.windowHandlers.WindowHandlers;


import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class Base1 {
    //Чтобы работать с ConfigurationManager - в Base1 должна быть ссылка на ApplicationManager
    public ConfigurationManager manager;

    protected WebDriver driver;
    protected Users user;
    protected WebDriverWait wait;
    public StringBuffer verificationErrors = new StringBuffer();
    public DmsLoginForm dmsLoginForm;
    protected LogBaseNew logger;
    protected WebDriverManager wdm;
    protected LocalWebDriverFactory lwf = new LocalWebDriverFactory();
    protected DefaultWebDriverManager defaultWebDriverManager;

    //non-static init (perform BEFORE constructor)
    {
        manager = ConfigurationManager.getInstance();
        logger = manager.getLogger(manager.getLoggerFromEnv());
    }


    @BeforeClass
    public void turnOnMap2() throws Exception {
        logger.log("Navigating to test url");
        //driver = defaultWebDriverManager.getWebDriver();
        driver = lwf.create();
        driver.manage().window().maximize();
        //driver = manager.getWebDriverHelperNew().getDriver();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        manager = ConfigurationManager.getInstance(driver);
        //logger.log("Navigating to test url");
        //driver = manager.getWebDriverHelperNew().getDriver();
        //driver.get(PropertyLoader.loadProperty("dms.url"));
        //manager = ConfigurationManager.getInstance(driver);
        logger.log("Log in to DMS under Supervisor");
        manager.getDmsLoginForm(driver).loginToDMSUnderSupervisor();
        //WindowHandlers.dismissAlert(driver);
        logger.log("Click on menu 'User'");
        manager.getDmsMainPage(driver).clickOnUsersMenu();
        logger.log("Open User editor");
        //wait.until(ExpectedConditions.presenceOfElementLocated(user.getRootUser()));
        //wait.until(ExpectedConditions.visibilityOf(user.getRootUser()));
        manager.getUsers(driver).openUserEditor();
        logger.log("Turn on MAP2");
        manager.getUserEditor(driver).turnOnMAP2();
        logger.log("Go to WebsiteMenu");
        manager.getWebsite(driver).clickOnWebsiteMenu();
        logger.log("Disable captcha");
        manager.getWebsite(driver).disableCaptcha();
        logger.log("Set JQuery 1.11.2");
        manager.getWebsite(driver).setjQueryVersion();
        logger.log("Open Settings - Review - select all 5 parameters");
        driver.get(PropertyLoader.loadProperty("dms.url"));
        manager.getDmsMainPage(driver).clickOnSettingsSubmenuReviewItem();
        manager.getSettingsReviewDealershipReviewSettings(driver).selectAllCheckbox();
        manager.getSettingsReviewDealershipReviewSettings(driver).clickSave();
        logger.log("Back to DMS main page");
        driver.get(PropertyLoader.loadProperty("dms.url"));
        logger.log("Go to MAP2");
        manager.getDmsMainPage(driver).clickToolsSubmenuMAP2Item();
        logger.log("Click on Dealer List tab");
        manager.getMap2MainPage(driver).openDealerListTab();
        logger.log("Add new Page");
        manager.getMap2MainPage(driver).addNewPage();
        logger.log("Add widget name");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getNameInput(), "dealerlist");
        logger.log("Add widget title");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getTitleInput(), "dealerlist");
        logger.log("Click on 'Library tab'");
        manager.getPageEditor(driver).clickOnLibrary();
        logger.log("drag and drop Dealer List icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconDealerList(),
                manager.getPageEditor(driver).getEmptyContainer());
        logger.log("Click on activation button");
        manager.getPageEditor(driver).getActivateButton().click();
        logger.log("Click on MAP button");
        manager.getPageEditor(driver).clickOnMapButton();
        logger.log("Click on Dealer Review tab");
        manager.getMap2MainPage(driver).openDealerReviewTab();
        logger.log("Add new Page");
        manager.getMap2MainPage(driver).addNewPage();
        logger.log("Click on Page Settings");
        manager.getPageEditor(driver).getPageSettingsTab().click();
        logger.log("Add widget name");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getNameInput(), "dealerreview");
        logger.log("Add widget title");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getTitleInput(), "dealerreview");
        logger.log("Click on 'Library tab'");
        manager.getPageEditor(driver).clickOnLibrary();
        logger.log("drag and drop Dealer Review icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconDealerReview(),
                manager.getPageEditor(driver).getEmptyContainer());
        logger.log("Click on activation button");
        manager.getPageEditor(driver).getActivateButton().click();
        logger.log("Click on MAP button");
        manager.getPageEditor(driver).clickOnMapButton();

        logger.log("Click on Dealer Review Form tab");
        manager.getMap2MainPage(driver).openDealerReviewDetailsTab();
        logger.log("Add new Page");
        manager.getMap2MainPage(driver).addNewPage();
        logger.log("Click on Page Settings");
        manager.getPageEditor(driver).getPageSettingsTab().click();
        logger.log("Add widget name");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getNameInput(), "dealerreview-form");
        logger.log("Add widget title");
        manager.getPage(driver).inputText(manager.getPageEditor(driver).getTitleInput(), "dealerreview-form");
        logger.log("Click on 'Library tab'");
        manager.getPageEditor(driver).clickOnLibrary();
        logger.log("drag and drop Dealer Review Form icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconDealerReviewForm(),
                manager.getPageEditor(driver).getEmptyContainer());
        logger.log("Click on activation button");
        manager.getPageEditor(driver).getActivateButton().click();
        logger.log("Click on MAP button");
        manager.getPageEditor(driver).clickOnMapButton();

        logger.log("Click on Dealer List tab");
        manager.getMap2MainPage(driver).openDealerListTab();
        logger.log("Click on Edit button");
        manager.getMap2MainPage(driver).clickEditButton();
        logger.log("Click on Preview Page button");
        manager.getPageEditor(driver).getPreviewPage().click();
        logger.log("Switch to new opened window");
        WindowHandlers.switchToCertainWindow(driver, 1);
        logger.log("Click on Visit on Website");
        manager.getPreviewPage(driver).getVisitOnVebsite().click();
        logger.log("Switch from Preview Page to DWS");
        WindowHandlers.switchToCertainWindow(driver, 2);
        logger.log("Click button Close");
        manager.getDealerList(driver).getCloseButton().click();



        /*logger.log("click on Dealer List widget");
        action.moveToElement(manager.getPageEditor(driver).getDealerListWidget()).doubleClick().perform();*/


    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();

    }


    public boolean waitForJSandJQueryToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 35);
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
                    return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

}
