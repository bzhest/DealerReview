package dealerReviewForm;

import bases.Base1;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by SYSTEM on 06.04.2017.
 */
public class AreDealerFormElementsDisplayed extends Base1 {

    //Form without a captcha
    @Test
    public void isWidgetDisplayed(){
        logger.log("Check if widget is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isWidgetExists());}

    @Test
     public void isWidgetTitleDisplayed(){
        logger.log("Check if widget title is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isWidgetTitleDisplayed());}

    @Test
    public void isRateYourDealerTitleDisplayed(){
        logger.log("Check if sign \"Rate Your Dealer\" title is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isRateYourDealerTitleDisplayed());}

    @Test
    public void isNicknameTitleDisplayed(){
        logger.log("Check if title \"Nickname\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isNicknameTitleDisplayed());}

    @Test
    public void isEmailTitleDisplayed(){
        logger.log("Check if title \"Email\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isEmailTitleDisplayed());}

    @Test
    public void isLocationTitleDisplayed(){
        logger.log("Check if title \"Location\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isLocationTitleDisplayed());}

    @Test
    public void isParameterYourOverallRatingDisplayed(){
        logger.log("Check if title \"Your Overall Rating \" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isParameterYourOverallRatingDisplayed());}

    @Test
    public void isParameterCustomerServiceDisplayed(){
        logger.log("Check if title \"Customer Service\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isParameterCustomerServiceDisplayed());}

    @Test
    public void isParameterBuyingProcessDisplayed(){
        logger.log("Check if title \"Buying Process\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isParameterBuyingProcessDisplayed());}

    @Test
    public void isParameterQualityOfRepairDisplayed(){
        logger.log("Check if title \"Quality of Repair\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isParameterQualityOfRepairDisplayed());}

    @Test
    public void isParameterOverallFacilitiesDisplayed(){
        logger.log("Check if title \"Overall Facilities\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isParameterOverallFacilitiesDisplayed());}

    @Test
    public void isReviewTitleDisplayed(){
        logger.log("Check if title \"Review Title\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isReviewTitleDisplayed());}

    @Test
    public void isReviewTextDisplayed(){
        logger.log("Check if title \"Review Text\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isReviewTextDisplayed());}

    @Test
    public void isRecomendThisDealerOptionDisplayed(){
        logger.log("Check if title \"Recommend this dealer\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isRecomendThisDealerOptionDisplayed());}

    @Test
    public void isPurchaseAVehicleFromThisDealerOptionDisplayed(){
        logger.log("Check if title \"Purchased a vehicle from this dealer\" is displayed");
        Assert.assertTrue(app.getDealerReviewDWS().isPurchaseAVehicleFromThisDealerOptionDisplayed());}

    @Test
    public void countStarsNumber(){
        logger.log("Check if number of empty stars on a page is 25");
        Assert.assertEquals(app.getDealerReviewDWS().countStarsNumber(),25);}

}



    public boolean isStarsDisplayed(int parameterNumber) {
        try{
            stars.get(parameterNumber).isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isCheckboxNADisplayed() {
        try{
            checkboxNA.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isIconCrossDisplayed(int crossNumber) {
        try{
            iconCross.get(crossNumber).isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isSubmitButtonDisplayed() {
        try{
            submitButton.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }
