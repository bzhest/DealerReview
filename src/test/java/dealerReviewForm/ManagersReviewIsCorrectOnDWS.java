package dealerReviewForm;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.utilityHelpers.windowHandlers.WindowHandlers;
import utilities.utilityProject.dataProvider.DataProviders;
import utilities.utilityProject.properties.PropertyLoader;
import utilities.utilityProject.properties.PropertyLoaderCredentials;
import utilities.utilityProject.testBase.TestBase;

import java.util.ArrayList;

/**
 * Created by DWork on 09.08.2017.
 */
public class ManagersReviewIsCorrectOnDWS extends TestBase {

    private static String handle;

    @BeforeClass
    public void preconditions() {
        driver.get(PropertyLoader.loadProperty("dws.url") + "/dealer-list");
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
        manager.getToolsReviewsDealerReviewsPage(driver).deleteAllReviews();
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


}
