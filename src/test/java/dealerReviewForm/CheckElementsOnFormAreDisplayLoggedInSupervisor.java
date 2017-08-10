package dealerReviewForm;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.utilityHelpers.data.api.StateDataMapper;
import utilities.utilityHelpers.data.state.FileStateDateMapper;
import utilities.utilityHelpers.data.state.State;
import utilities.utilityProject.properties.PropertyLoader;
import utilities.utilityHelpers.cookies.Cookies;
import utilities.utilityHelpers.windowHandlers.WindowHandlers;
import utilities.utilityProject.testBase.*;

import java.util.Set;

/**
 * Here are verified, that all default form fields and titles, bottoms are present
 */

public class CheckElementsOnFormAreDisplayLoggedInSupervisor extends TestBase {

    protected String userFirstSecondName;
    protected String userEmail;
    protected String userAddress;
    protected String userCity;
    protected String userState;

    @BeforeClass
    public void setUpDealerReviewForm() {
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
        manager.getUserEditor(driver).getGeneralTab().click();
        userFirstSecondName = manager.getUserEditor(driver).getGeneralTab(driver).getFirstNameAndLastName();
        userEmail = manager.getUserEditor(driver).getGeneralTab(driver).getEmailStringValue();
        System.out.println(userFirstSecondName);
        logger.log("Save User Address, City, State from Address tab");
        manager.getUserEditor(driver).getAddressTab().click();
        sleep(2);
        userAddress = manager.getUserEditor(driver).getAddressTab(driver).getAddressText();
        userCity = manager.getUserEditor(driver).getAddressTab(driver).getCityText();
        userState = manager.getUserEditor(driver).getAddressTab(driver).getStateText();
        System.out.println("address: " + userAddress + ", " + "city: " + userCity + ", " + "state: " + userState);
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
        logger.log("drag and drop Login Form icon");
        manager.getPageEditor(driver).addAnWidget(
                manager.getPageEditor(driver).getIconLoginForm(),
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
        //manager.getDealerList(driver).getCloseButton().click();
        manager.getZipPopUp(driver).buttonCloseClick();
        logger.log("Click on Add Review button");
        //manager.getDealerList(driver).clickFirstAddReviewButton();
        //manager.getDealerList(driver).findDealerByDealerName("Solomia Vasilivna").iGetReviewsNumber();
        //manager.getDealerList(driver).findDealerByDealerName("Solomia Vasilivna").dGetStarsNumber(driver);
        manager.getDealerList(driver).findDealerByDealerName("Solomia Vasilivna").clickButtonAddReview();
        WindowHandlers.switchToCertainWindow(driver, 3);
        sleep(1);
    }

    @Test(description = "Widget Dealer Review Form is displayed")
    public void isWidgetDisplayed() {
        //driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review-form_dealer_6287.html");
        //waitForJSandJQueryToLoad();
        logger.log("Check, if widget is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isWidgetExists());
    }

    @Test
    public void isWidgetTitleDisplayed() {
        logger.log("Check if widget title is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isWidgetTitleDisplayed());
    }

    @Test
    public void isRateYourDealerTitleDisplayed() {
        logger.log("Check if sign \"Rate Your Dealer\" title is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isRateYourDealerTitleDisplayed());
    }

    @Test
    public void isNicknameTitleDisplayed() {
        logger.log("Check if title \"Nickname\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isNicknameTitleDisplayed());
    }

    @Test
    public void isEmailTitleDisplayed() {
        logger.log("Check if title \"Email\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isEmailTitleDisplayed());
    }

    @Test
    public void isLocationTitleDisplayed() {
        logger.log("Check if title \"Location\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isLocationTitleDisplayed());
    }

    @Test
    public void isParameterYourOverallRatingDisplayed() {
        logger.log("Check if title \"Your Overall Rating \" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterYourOverallRatingDisplayed());
    }

    @Test
    public void isParameterCustomerServiceDisplayed() {
        logger.log("Check if title \"Customer Service\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterCustomerServiceDisplayed());
    }

    @Test
    public void isParameterBuyingProcessDisplayed() {
        logger.log("Check if title \"Buying Process\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterBuyingProcessDisplayed());
    }

    @Test
    public void isParameterQualityOfRepairDisplayed() {
        logger.log("Check if title \"Quality of Repair\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterQualityOfRepairDisplayed());
    }

    @Test
    public void isParameterOverallFacilitiesDisplayed() {
        logger.log("Check if title \"Overall Facilities\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterOverallFacilitiesDisplayed());
    }

    @Test
    public void isReviewTitleDisplayed() {
        logger.log("Check if title \"Review Title\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isReviewTitleDisplayed());
    }

    @Test
    public void isReviewTextDisplayed() {
        logger.log("Check if title \"Review Text\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isReviewTextDisplayed());
    }

    @Test
    public void isRecomendThisDealerOptionDisplayed() {
        logger.log("Check if title \"Recommend this dealer\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isRecomendThisDealerOptionDisplayed());
    }

    @Test
    public void isPurchaseAVehicleFromThisDealerOptionDisplayed() {
        logger.log("Check if title \"Purchased a vehicle from this dealer\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isPurchaseAVehicleFromThisDealerOptionDisplayed());
    }

    @Test
    public void countStarsNumber() {
        //driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review-form_dealer_6287.html");
        logger.log("Check if number of empty stars on a page is 25");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).countStarsNumber(), 25);
    }

    @Test
    public void isCheckboxNADisplayed() {
        logger.log("Check if checkbox \"NA\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isCheckboxNADisplayed());
    }

    @Test
    public void countCrossIconsNumber() {
        logger.log("Check if number of icons \"Cross\" to clean stars is 5");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).countCrossIconsNumber(), 5);
    }

    @Test
    public void isSubmitButtonDisplayed() {
        logger.log("Check if button \"Submit\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isSubmitButtonDisplayed());
    }

    @Test
    public void isUsersNicknameIsCorrect() {
        logger.log("Check if field \"Nickname\" contains correct user's First and Second name");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getNicknameInput().getAttribute("value"), userFirstSecondName);
    }

    @Test
    public void isUsersEmailIsCorrect() {
        logger.log("Check if field \"Email\" contains correct users email");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getEmailInput().getAttribute("value"), userEmail);
    }

    @Test
    public void isUsersLocationIsCorrect() {
        logger.log("Check if field \"Location\" contains correct users location");
        StateDataMapper file = new FileStateDateMapper();
        State state = file.getStateObjectByFullName(userState);
        String fullAddress = userAddress + ", " + userCity + " " + state.getShortName();
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getLocationInput().getAttribute("value"), fullAddress);
    }
}

