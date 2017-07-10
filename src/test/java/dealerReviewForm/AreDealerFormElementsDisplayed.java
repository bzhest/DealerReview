package dealerReviewForm;

import bases.Base1;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.data.api.StateDataMapper;
import utility.data.state.FileStateDateMapper;
import utility.data.state.State;

/** Here are verified, that all default form fields and titles, bottoms are present */

public class AreDealerFormElementsDisplayed extends Base1 {

    @Test
    public void isWidgetDisplayed(){
        //driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review-form_dealer_6287.html");
        //waitForJSandJQueryToLoad();
        logger.log("Check, if widget is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isWidgetExists());}

    @Test
     public void isWidgetTitleDisplayed(){
        logger.log("Check if widget title is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isWidgetTitleDisplayed());}

    @Test
    public void isRateYourDealerTitleDisplayed(){
        logger.log("Check if sign \"Rate Your Dealer\" title is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isRateYourDealerTitleDisplayed());}

    @Test
    public void isNicknameTitleDisplayed(){
        logger.log("Check if title \"Nickname\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isNicknameTitleDisplayed());}

    @Test
    public void isEmailTitleDisplayed(){
        logger.log("Check if title \"Email\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isEmailTitleDisplayed());}

    @Test
    public void isLocationTitleDisplayed(){
        logger.log("Check if title \"Location\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isLocationTitleDisplayed());}

    @Test
    public void isParameterYourOverallRatingDisplayed(){
        logger.log("Check if title \"Your Overall Rating \" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterYourOverallRatingDisplayed());}

    @Test
    public void isParameterCustomerServiceDisplayed(){
        logger.log("Check if title \"Customer Service\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterCustomerServiceDisplayed());}

    @Test
    public void isParameterBuyingProcessDisplayed(){
        logger.log("Check if title \"Buying Process\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterBuyingProcessDisplayed());}

    @Test
    public void isParameterQualityOfRepairDisplayed(){
        logger.log("Check if title \"Quality of Repair\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterQualityOfRepairDisplayed());}

    @Test
    public void isParameterOverallFacilitiesDisplayed(){
        logger.log("Check if title \"Overall Facilities\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isParameterOverallFacilitiesDisplayed());}

    @Test
    public void isReviewTitleDisplayed(){
        logger.log("Check if title \"Review Title\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isReviewTitleDisplayed());}

    @Test
    public void isReviewTextDisplayed(){
        logger.log("Check if title \"Review Text\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isReviewTextDisplayed());}

    @Test
    public void isRecomendThisDealerOptionDisplayed(){
        logger.log("Check if title \"Recommend this dealer\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isRecomendThisDealerOptionDisplayed());}

    @Test
    public void isPurchaseAVehicleFromThisDealerOptionDisplayed(){
        logger.log("Check if title \"Purchased a vehicle from this dealer\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isPurchaseAVehicleFromThisDealerOptionDisplayed());}

    @Test
    public void countStarsNumber(){
        //driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review-form_dealer_6287.html");
        logger.log("Check if number of empty stars on a page is 25");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).countStarsNumber(),25);}

    @Test
    public void isCheckboxNADisplayed(){
        logger.log("Check if checkbox \"NA\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isCheckboxNADisplayed());}

    @Test
    public void countCrossIconsNumber(){
        logger.log("Check if number of icons \"Cross\" to clean stars is 5");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).countCrossIconsNumber(),5);}

    @Test
    public void isSubmitButtonDisplayed(){
        logger.log("Check if button \"Submit\" is displayed");
        Assert.assertTrue(manager.getDealerReviewDWS(driver).isSubmitButtonDisplayed());}

    @Test
    public void isUsersNicknameIsCorrect(){
        logger.log("Check if field \"Nickname\" contains correct user's First and Second name");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getNicknameInput().getAttribute("value"),userFirstSecondName);
    }

    @Test
    public void isUsersEmailIsCorrect(){
        logger.log("Check if field \"Email\" contains correct users email");
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getEmailInput().getAttribute("value"),userEmail);
    }

    @Test
    public void isUsersLocationIsCorrect(){
        logger.log("Check if field \"Location\" contains correct users location");
        StateDataMapper file = new FileStateDateMapper();
        State state = file.getStateObjectByFullName(userState);
        String fullAddress = userAddress + ", " + userCity + " " + state.getShortName();
        Assert.assertEquals(manager.getDealerReviewDWS(driver).getLocationInput().getAttribute("value"),fullAddress);
    }
}

