package dealerReviewForm;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilityHelpers.windowHandlers.WindowHandlers;
import utilityProject.dataProvider.DataProviders;
import utilityProject.properties.PropertyLoader;
import utilityProject.properties.PropertyLoaderCredentials;
import utilityProject.testBase.TestBase;

/**
 * Created by DWork on 09.08.2017.
 */
public class ManagersReviewIsCorrectOnDWS extends TestBase {

    @BeforeClass
    public void preconditions() {
        driver.get(PropertyLoader.loadProperty("dws.url") + "/dealer-list");
        manager.getZipPopUp(driver).buttonCloseClick();
        manager.getLoginForm(driver).inputLoginPassword(
                PropertyLoaderCredentials.loadProperty("loginValueManager"),
                PropertyLoaderCredentials.loadProperty("passwordValueManager"));
        logger.log("Click on Add Review button");
        manager.getDealerList(driver).findDealerByDealerName("Jack Novak").clickButtonAddReview();
        WindowHandlers.switchToCertainWindow(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(manager.getDealerReviewForm(driver).getNicknameTitle()));

    }

    @Test(dataProvider = "set of stars", dataProviderClass = DataProviders.class)
    public void summOfStarsIsCorrect(String parameterNumber, String starNumbers, String starsAvarage) {
        manager.getDealerReviewForm(driver).getTitleInput().sendKeys("Where are testing Stars here");
        manager.getDealerReviewForm(driver).getContentInput().sendKeys("Where are testing Stars here");
        manager.getDealerReviewForm(driver).selectStarsOnParameters(parameterNumber,starNumbers);
        manager.getDealerReviewForm(driver).getSubmitButton().click();
        manager.getDealerReviewForm(driver).getPostFormReturnBtn().click();
        sleep(5);

    }

}
