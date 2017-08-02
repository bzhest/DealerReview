package dealerReviewForm;

import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeClass;
import utility.base.TestBase;
import utility.properties.PropertyLoader;
import utility.properties.PropertyLoaderCredentials;
import utility.utils.cookies.Cookies;

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
        manager.getLoginForm(driver).inputLoginPassword(PropertyLoaderCredentials.loadProperty("loginValueSupervisor"));
    }
}
