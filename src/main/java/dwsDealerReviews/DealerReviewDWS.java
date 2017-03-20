package dwsDealerReviews;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import utility.LogFactory;

import java.util.List;

/**
 * Created by Andrey on 18.03.2017.
 */
public class DealerReviewDWS {
    private static final Logger LOG = LogFactory.getLogger(DealerReviewDWS.class);

    //Field titles

    @FindBy(how = How.XPATH, using = "//div[@class='panel-title']")
    private WebElement widgetTitle;

    @FindBy(how = How.XPATH, using = "//legend[contains(text(), 'Rate Your Dealer')]")
    private WebElement rateYourDealerTitle;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Nickname')]")
    private WebElement nicknameTitle;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Email')]")
    private WebElement emailTitle;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Your location')]")
    private WebElement locationTitle;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Your Overall Rating')]")
    private WebElement parameterYourOverallRating;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Customer Service:')]")
    private WebElement parameterCustomerService;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Buying Process:')]")
    private WebElement parameterBuyingProcess;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Quality of Repair:')]")
    private WebElement parameterQualityOfRepair;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Overall Facilities:')]")
    private WebElement parameterOverallFacilities;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Review Title:')]")
    private WebElement reviewTitle;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Review Text:')]")
    private WebElement reviewText;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Recommend this dealer:')]")
    private WebElement recomendThisDealerOption;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Purchased a vehicle from this dealer?')]")
    private WebElement purchaseAVehicleFromThisDealerOption;

    @FindBy(how = How.CSS, using = "span.stars")
    private List<WebElement> stars;

    @FindBy(how = How.CSS, using = ".btnNaRating")
    private WebElement checkboxNA;

    @FindBy(how = How.CSS, using = ".btnClRating")
    private List<WebElement> iconCross;

    @FindBy(how = How.CSS, using = "#revf-submit")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using = "(//div[@class='panel-body']//div[@class='text-center'])[1]")
    private WebElement postForm;

    @FindBy(how = How.CSS, using = "button.btn.btn-default.return")
    private WebElement postFormReturnBtn;

    @FindBy(how = How.CSS, using = "button.btn.btn-primary.add_one_more")
    private WebElement postFormAddOneMoreBtn;


    //Captcha

    @FindBy(how = How.XPATH, using = "//div[@class='row captcha_container capchaB']")
    private WebElement captcha;

    @FindBy(how = How.CLASS_NAME, using = "capchaImgWrap")
    private WebElement captchaImg;

    @FindBy(how = How.CLASS_NAME, using = "captcha_input")
    private WebElement captchaInput;

    @FindBy(how = How.CLASS_NAME, using = "captcha_refresh")
    private WebElement captchaRefresh;

    @FindBy(how = How.XPATH, using = "//div[@class='recaptcha_v2_div_wrapper']/div[@class='recaptcha-v2-container']//iframe")
    private WebElement reCaptcha2Frame;

    @FindBy(how = How.ID, using = "recaptcha-anchor")
    private WebElement reCaptcha2Checkbox;

    @FindBy(how = How.CLASS_NAME, using = "motion-captcha")
    private WebElement motionCaptcha;

    @FindBy(how = How.XPATH, using = "//div[@class='motion-captcha col-lg-12']/p")
    private WebElement motionCaptchaText;

    @FindBy(how = How.XPATH, using = "//div[@class='motion-captcha col-lg-12']//canvas")
    private WebElement motionCaptchaCanvas;

    .form-group .radio-inline input[name = "param_recomend"]   :first-child

    //Asterics

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk form-control-feedback text-danger']")
    private List <WebElement> astericsInputFields;

    @FindBy(how = How.XPATH, using = "//span[@class='glyphicon glyphicon-asterisk text-danger']")
    private WebElement astericsNote;

    @FindBy(how = How.CSS, using = "span#form_validate_true_0")
    private WebElement astericsYourOverallRating;

    //Inputs

    @FindBy(how = How.CSS, using = "input[name='user_nickname']")
    private WebElement nicknameInput;

    @FindBy(how = How.CSS, using = "input[name='user_email']")
    private WebElement userEmailInput;

    @FindBy(how = How.CSS, using = "input[name='user_location']")
    private WebElement userLocationInput;

    @FindBy(how = How.CSS, using = "input[name='title']")
    private WebElement titleInput;

    @FindBy(how = How.CSS, using = "textarea[name='content']")
    private WebElement contentInput;

    /*methods for check if element exists*/

    public boolean isWidgetTitleDisplayed() {
        try {
            widgetTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isRateYourDealerTitleDisplayed() {
        try{
            rateYourDealerTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isNicknameTitleDisplayed() {
        try{
            nicknameTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isEmailTitleDisplayed() {
        try{
            emailTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isLocationTitleDisplayed() {
        try{
            locationTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isParameterYourOverallRatingDisplayed() {
        try{
            parameterYourOverallRating.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isParameterCustomerServiceDisplayed() {
        try{
            parameterCustomerService.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isParameterBuyingProcessDisplayed() {
        try{
            parameterBuyingProcess.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isParameterQualityOfRepairDisplayed() {
        try{
            parameterQualityOfRepair.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isParameterOverallFacilitiesDisplayed() {
        try{
            parameterOverallFacilities.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isReviewTitleDisplayed() {
        try{
            reviewTitle.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isReviewTextDisplayed() {
        try{
            reviewText.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isRecomendThisDealerOptionDisplayed() {
        try{
            recomendThisDealerOption.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    public boolean isPurchaseAVehicleFromThisDealerOptionDisplayed() {
        try{
            purchaseAVehicleFromThisDealerOption.isDisplayed();
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
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

    public boolean isPostFormDisplayed() {
        try {
            postForm.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isPostFormReturnBtnDisplayed() {
        try {
            postFormReturnBtn.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isPostFormAddOneMoreBtnDisplayed() {
        try {
            postFormAddOneMoreBtn.isDisplayed();
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /*method click on button*/

    public void clickOnSumbitButton(){submitButton.click();}
    public void clickOnPostFormReturnButton(){postFormReturnBtn.click();}
    public void clickOnPostFormAddOneMoreButton(){postFormAddOneMoreBtn.click();}

}
