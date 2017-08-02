package dealerReviewForm;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.base.TestBase;
import utility.data.api.StateDataMapper;
import utility.data.state.FileStateDateMapper;
import utility.data.state.State;
import utility.utils.cookies.Cookies;
import utility.utils.windowHandlers.WindowHandlers;

/**
 * Created by DWork on 01.08.2017.
 */
public class CheckElementsOnFormAreDisplayLoggedOutUser extends TestBase{

@BeforeClass
    public void openUrl(){
    driver.get("http://www.solomia.andreyb.ixloo.com/dealer-list");
    Cookies.makeLogOut(driver);
    logger.log("Click button Close");
    manager.getZipPopUp(driver).buttonCloseClick();
    logger.log("Click on Add Review button");

    manager.getDealerList(driver).findDealerByDealerName("Solomia Vasilivna").getButtonAddReview().click();
    WindowHandlers.switchToCertainWindow(driver, 1);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".panel-title"))));
}

    @Test(description = "field should be empty")
    public void isUsersNicknameIsCorrect(){
        logger.log("Check if field \"Nickname\" contains correct user's First and Second name");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getNicknameInput().getAttribute("value"),"");
    }

    @Test(description = "field should be empty")
    public void isUsersEmailIsCorrect(){
        logger.log("Check if field \"Email\" contains correct users email");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getEmailInput().getAttribute("value"),"");
    }

    @Test (description = "field should be empty")
    public void isUsersLocationIsCorrect(){
        logger.log("Check if field \"Location\" contains correct users location");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getLocationInput().getAttribute("value"),"");
    }

}
