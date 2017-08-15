package dealerReviewForm;

import dealerReviewForm.executor.Executor;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.utilityHelpers.cookies.Cookies;
import utilities.utilityHelpers.windowHandlers.WindowHandlers;
import utilities.utilityProject.dataProvider.DataProviders;
import utilities.utilityProject.properties.PropertyLoader;
import utilities.utilityProject.properties.PropertyLoaderCredentials;
import utilities.utilityProject.testBase.TestBase;

import java.util.Set;

/**
 * Created by DWork on 09.08.2017.
 */
public class CheckStarsCountingLogicIsCorrect extends TestBase {

    private static String handle;

    @BeforeClass
    public void preconditions() {

        //----------------------------
        driver.get(PropertyLoader.loadProperty("dms.url"));
        logger.log("Log in to DMS under Supervisor");
        manager.getDmsLoginForm(driver).loginToDMSUnderSupervisor();
        logger.log("Save cookies");
        Set<Cookie> cookie = Cookies.saveCookies(driver);
        logger.log("Click on menu 'User'");
        manager.getDmsMainPage(driver).clickOnUsersMenu();
        logger.log("Open User editor");
        manager.getUsers(driver).openUserEditor(manager.getUsers(driver).getRootUser());
        logger.log("Save User First and Last Name, Email from General Tab");
        manager.getUserEditor(driver).getAccessTab().click();
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


        new Executor().setUpDealerListPage();
        new Executor().setUpDealerReviewPage();
        new Executor().setUpDealerReviewFormPage();
        //----------------------------
        driver.get(PropertyLoader.loadProperty("dws.url") + "/dealer-list");
        Cookies.makeLogOut(driver);
        manager.getZipPopUp(driver).buttonCloseClick();
        manager.getLoginForm(driver).inputLoginPassword(
                PropertyLoaderCredentials.loadProperty("loginValueManager"),
                PropertyLoaderCredentials.loadProperty("passwordValueManager"));
        logger.log("Click on Add Review button");
        handle = driver.getWindowHandle();//remember current windowHandle
    }

    @Override
    protected void afterClass() {
        super.afterSuite();
        manager.getToolsReviewsDealerReviewsPage(driver).deleteAllReviews(manager);
    }

    @Test(dataProvider = "Set of stars for 1 parameter", dataProviderClass = DataProviders.class)
    public void summOfStarsIsCorrectWithParameter_1(String parameterNumber, String starNumbers, Double starsAvarage,String reviewTitle) {
        manager.getDealerList(driver).findDealerByDealerName("Jack Novak").clickButtonAddReview();
        WindowHandlers.switchToCertainWindow(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(manager.getDealerReviewForm(driver).getNicknameTitle()));
        manager.getDealerReviewForm(driver).getTitleInput().sendKeys(reviewTitle);
        manager.getDealerReviewForm(driver).getContentInput().sendKeys("Where are testing Stars here");
        manager.getDealerReviewForm(driver).selectStarsOnParameters(parameterNumber,starNumbers);
        manager.getDealerReviewForm(driver).clickOnSubmitButton();
        manager.getDealerReviewForm(driver).clickPostFormReturnButton();
        Assert.assertEquals(manager.getDealerReviewPage(driver).getDealerReviewByReviewTitle(reviewTitle).dGetStarsNumber(driver),starsAvarage);
        winHand.switchToAnotherWindow(1);
        winHand.closeAllWindowsExceptCurrent();
    }

    @Test(dataProvider = "Set of stars for 2 parameters", dataProviderClass = DataProviders.class)
    public void summOfStarsIsCorrectWithParameter_2(String parameterNumber1, String starNumbers1, String parameterNumber2, String starNumbers2, Double starsAvarage,String reviewTitle) {
        manager.getDealerList(driver).findDealerByDealerName("Jack Novak").clickButtonAddReview();
        WindowHandlers.switchToCertainWindow(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(manager.getDealerReviewForm(driver).getNicknameTitle()));
        manager.getDealerReviewForm(driver).getTitleInput().sendKeys(reviewTitle);
        manager.getDealerReviewForm(driver).getContentInput().sendKeys("Where are testing Stars here");
        manager.getDealerReviewForm(driver).selectStarsOnParameters(parameterNumber1,starNumbers1);
        manager.getDealerReviewForm(driver).selectStarsOnParameters(parameterNumber2,starNumbers2);
        manager.getDealerReviewForm(driver).clickOnSubmitButton();
        manager.getDealerReviewForm(driver).clickPostFormReturnButton();
        Assert.assertEquals(manager.getDealerReviewPage(driver).getDealerReviewByReviewTitle(reviewTitle).dGetStarsNumber(driver),starsAvarage);
        winHand.switchToAnotherWindow(1);
        winHand.closeAllWindowsExceptCurrent();
    }

    @Test(dataProvider = "Set of stars for 3 parameters", dataProviderClass = DataProviders.class)
    public void summOfStarsIsCorrectWithParameter_3(String parameterNumber1, String starNumbers1, String parameterNumber2, String starNumbers2, String parameterNumber3, String starNumbers3, Double starsAvarage,String reviewTitle) {
        manager.getDealerList(driver).findDealerByDealerName("Jack Novak").clickButtonAddReview();
        WindowHandlers.switchToCertainWindow(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(manager.getDealerReviewForm(driver).getNicknameTitle()));
        manager.getDealerReviewForm(driver).getTitleInput().sendKeys(reviewTitle);
        manager.getDealerReviewForm(driver).getContentInput().sendKeys("Where are testing Stars here");
        manager.getDealerReviewForm(driver).selectStarsOnParameters(parameterNumber1,starNumbers1);
        manager.getDealerReviewForm(driver).selectStarsOnParameters(parameterNumber2,starNumbers2);
        manager.getDealerReviewForm(driver).selectStarsOnParameters(parameterNumber3,starNumbers3);
        manager.getDealerReviewForm(driver).clickOnSubmitButton();
        manager.getDealerReviewForm(driver).clickPostFormReturnButton();
        Assert.assertEquals(manager.getDealerReviewPage(driver).getDealerReviewByReviewTitle(reviewTitle).dGetStarsNumber(driver),starsAvarage);
        winHand.switchToAnotherWindow(1);
        winHand.closeAllWindowsExceptCurrent();
    }


}
