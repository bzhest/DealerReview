package bases;


import dms.DmsLoginForm;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import settings.Users;
import utility.base.TestBase;
import utility.browser.users.DefaultWebDriverManager;
import utility.config.ConfigurationManager;
import utility.browser.users.LocalWebDriverFactory;
import utility.browser.api.WebDriverManager;
import utility.data.User;
import utility.logger.StdLogger;
import utility.logger.api.LogBaseNew;
import utility.properties.PropertyLoader;
import utility.utils.windowHandlers.WindowHandlers;


import static org.testng.Assert.fail;

/**
 * Created by SYSTEM on 04.04.2017.
 */
public class Base1 extends TestBase{
    //Чтобы работать с ConfigurationManager - в Base1 должна быть ссылка на ApplicationManager
    public ConfigurationManager manager;
    protected LocalWebDriverFactory lwf = new LocalWebDriverFactory();


    @Override
    protected void beforeTest() {
        logger.log("Navigating to test url");
        driver.manage().window().maximize();
        driver.get(PropertyLoader.loadProperty("dms.url"));
        manager = ConfigurationManager.getInstance(driver);
    }

    @BeforeClass
    public void turnOnMap2() throws Exception {

        logger.log("Log in to DMS under Supervisor");
        manager.getDmsLoginForm(driver).loginToDMSUnderSupervisor();
        logger.log("Click on menu 'User'");
        manager.getDmsMainPage(driver).clickOnUsersMenu();
        logger.log("Open User editor");

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
        logger.log("Click on Add Review button");
        manager.getDealerList(driver).clickFirstAddReviewButton();
        Thread.sleep(1000);

    }
}
