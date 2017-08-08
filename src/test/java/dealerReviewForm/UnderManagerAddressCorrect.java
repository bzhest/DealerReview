package dealerReviewForm;

import dms.DmsLoginForm;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.base.TestBase;
import utility.data.api.StateDataMapper;
import utility.data.state.FileStateDateMapper;
import utility.data.state.State;
import utility.properties.PropertyLoader;
import utility.properties.PropertyLoaderCredentials;
import utility.utils.cookies.Cookies;
import utility.utils.windowHandlers.WindowHandlers;

import java.util.Set;

/**
 * Created by Andrey on 02.08.2017.
 */
public class UnderManagerAddressCorrect extends TestBase{

    protected String userFirstSecondName;
    protected String userEmail;
    protected String userAddress;
    protected String userCity;
    protected String userState;

    @BeforeClass
    public void preconditions(){
        driver.get(PropertyLoader.loadProperty("dms.url"));
        Cookies.makeLogOut(driver);
        logger.log("Log in to DMS under Supervisor");
        manager.getDmsLoginForm(driver).loginToDMSUnderSupervisor();
        logger.log("Save cookies");
        Set<Cookie> cookie = Cookies.saveCookies(driver);
        logger.log("Click on menu 'User'");
        manager.getDmsMainPage(driver).clickOnUsersMenu();
        logger.log("Open User editor");
        manager.getUsers(driver).openUserEditor(manager.getUsers(driver).getManager());
        logger.log("Save User First and Last Name, Email from General Tab");
        manager.getUserEditor(driver).getGeneralTab().click();
        userFirstSecondName = manager.getUserEditor(driver).getGeneralTab(driver).getFirstNameAndLastName();
        userEmail = manager.getUserEditor(driver).getGeneralTab(driver).getEmailStringValue();
        System.out.println(userFirstSecondName);
        logger.log("Save User Address, City, State from Address tab");
        manager.getUserEditor(driver).getAddressTab().click();
        userAddress = manager.getUserEditor(driver).getAddressTab(driver).getAddressText();
        userCity = manager.getUserEditor(driver).getAddressTab(driver).getCityText();
        userState = manager.getUserEditor(driver).getAddressTab(driver).getStateText();
        System.out.println("address: " + userAddress + ", " + "city: " + userCity + ", " + "state: " + userState);
        driver.get("http://www.solomia.andreyb.ixloo.com/dealer-list");
        manager.getZipPopUp(driver).buttonCloseClick();
        manager.getLoginForm(driver).inputLoginPassword(PropertyLoaderCredentials.loadProperty("loginValueManager"),PropertyLoaderCredentials.loadProperty("passwordValueManager"));
        logger.log("Click on Add Review button");
        manager.getDealerList(driver).findDealerByDealerName("Jack Novak").clickButtonAddReview();
        WindowHandlers.switchToCertainWindow(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(manager.getDealerReviewForm(driver).getNicknameTitle()));
    }



    @Test (description = "Fields contains manager's Nickname")
    public void isUsersNicknameIsCorrect(){
        logger.log("Check if field \"Nickname\" contains correct user's First and Second name");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getNicknameInput().getAttribute("value"),userFirstSecondName);
    }

    @Test (description = "Fields contains manager's Email")
    public void isUsersEmailIsCorrect(){
        logger.log("Check if field \"Email\" contains correct users email");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getEmailInput().getAttribute("value"),userEmail);
    }

    @Test(description = "Fields contains manager's location")
    public void isUsersLocationIsCorrect(){
        logger.log("Check if field \"Location\" contains correct users location");
        StateDataMapper file = new FileStateDateMapper();
        State state = file.getStateObjectByFullName(userState);
        String fullAddress = userAddress + ", " + userCity + " " + state.getShortName();
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getLocationInput().getAttribute("value"),fullAddress);
    }
}
