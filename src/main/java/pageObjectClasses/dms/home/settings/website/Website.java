/*dms Website General page*/
package pageObjectClasses.dms.home.settings.website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.utilityProject.page.Page;

/**
 * Created by Julia on 04.01.2017.
 */
public class Website extends Page {
    /*public Website(WebDriver webDriver) {
        super(webDriver);
    }*/
    public Website(WebDriver driver) {
        super(driver);
    }



    /*declare elements on the page*/
    @FindBy(how = How.ID, using = "tab2")
    private WebElement leadsEmailTab;

    @FindBy(how = How.ID, using = "tab7")
    private WebElement localizationTab;

    @FindBy(how = How.CSS, using = "#forms_captcha .button-style.b_edit.notranslate")
    private WebElement captchaEditBtn;

    @FindBy(how = How.CSS, using = "#forms_captcha  .button-style.b_save")
    private WebElement captchaSaveBtn;

    @FindBy(how = How.CSS, using = "input[name = 'forms_captcha'][value = '1']")
    private WebElement captchaOnRadio;

    @FindBy(how = How.CSS, using = "input[name = 'forms_captcha'][value = '0']")
    private WebElement captchaOffRadio;

    @FindBy(how = How.CSS, using = "#type_of_captcha .button-style.b_edit.notranslate")
    private WebElement captchaTypeEditBtn;

    @FindBy(how = How.CSS, using = "#type_of_captcha .button-style.b_save")
    private WebElement captchaTypeSaveBtn;

    @FindBy(how = How.CSS, using = "select[name = 'type_of_captcha']")
    private WebElement captchaTypeSelect;

    @FindBy(how = How.CSS, using = "#jquery_version .button-style.b_edit.notranslate")
    private WebElement jQueryEditBtn;

    @FindBy(how = How.CSS, using = "#jquery_version .button-style.b_save")
    private WebElement jQuerySaveBtn;

    @FindBy(how = How.CSS, using = "input[name = 'jquery_version']")
    private WebElement jQueryInput;

    @FindBy(how = How.CSS, using = "#jquery_version .settings_view.dotted_note")
    private WebElement jQueryValue;

    @FindBy(how = How.CSS, using = "#redirect_404 .button-style.b_edit.notranslate")
    private WebElement the404EditBtn;

    @FindBy(how = How.CSS, using = "#redirect_404 .button-style.b_save")
    private WebElement the404SaveBtn;

    @FindBy(how = How.CSS, using = "select#redirect_404")
    private WebElement the404Select;

   /* *//*open Leads Email tab*//*
    public LeadsEmail clickOnLeadsTab() {
        leadsEmailTab.click();
        return PageFactory.initElements(driver, LeadsEmail.class);
    }

    *//*open Localization tab *//*
    public Localization clickOnLocalizationTab() {
        localizationTab.click();
        return PageFactory.initElements(driver, Localization.class);
    }*/

    /*Turn on Captcha*/
    public void enableCaptcha() {
        captchaEditBtn.click();
        captchaOnRadio.click();
        captchaSaveBtn.click();
    }

    /*Turn off Captcha*/
    public void disableCaptcha() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#forms_captcha .button-style.b_edit.notranslate")));
        captchaEditBtn.click();
        captchaOffRadio.click();
        captchaSaveBtn.click();
    }

    /*set Captcha Type - Captcha*/
    public void setCaptchaType() {
        captchaTypeEditBtn.click();
        WebElement select = captchaTypeSelect;
        Select options = new Select(select);
        options.selectByValue("Captcha");
        captchaTypeSaveBtn.click();
    }

    /*set Captcha Type - ReCaptcha*/
    public void setReCaptchaType() {
        captchaTypeEditBtn.click();
        WebElement select = captchaTypeSelect;
        Select options = new Select(select);
        options.selectByValue("ReCaptcha");
        captchaTypeSaveBtn.click();
    }

    /*set Captcha Type - Motion*/
    public void setMotionCaptchaType() {
        captchaTypeEditBtn.click();
        WebElement select = captchaTypeSelect;
        Select options = new Select(select);
        options.selectByValue("Motion");
        captchaTypeSaveBtn.click();
    }

    /*set Captcha Type - ReCaptcha2*/
    public void setReCaptcha2Type() {
        captchaTypeEditBtn.click();
        WebElement select = captchaTypeSelect;
        Select options = new Select(select);
        options.selectByValue("ReCaptcha V2");
        captchaTypeSaveBtn.click();
    }

    /*set jQuery version - 1.11.2 (if it is not equal to that)*/
    public void setjQueryVersion() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.text_dealership"))));
            //waitForJSandJQueryToLoad();
        if (!jQueryValue.getText().equals("1.11.2")) {
            jQueryEditBtn.click();
            jQueryInput.clear();
            jQueryInput.sendKeys("1.11.2");
            jQuerySaveBtn.click();
        }
    }

    public void set404Redir(String value404) {
        the404EditBtn.click();
        WebElement select = the404Select;
        Select options = new Select(select);
        options.selectByVisibleText(value404);
    }

    public void clickOnWebsiteMenu(){
        //waitForJSandJQueryToLoad();
        waitFullPageLoading();
        driver.get("http://www.solomia.andreyb.ixloo.com/dms/settings/website#general");
    }
}