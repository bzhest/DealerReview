package dms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import page.Page;
import utility.ConfigurationManager;
import utility.PropertyLoaderCredentials;


/**
 * Created by SYSTEM on 16.03.2017.
 */
public class DmsLoginForm extends Page {

    //public DmsLoginForm (WebDriver webDriver){super(webDriver);}
    public DmsLoginForm (ConfigurationManager manager)
    {super(manager);}



    //Declare elements on a page
    @FindBy(how = How.CSS, using = "#login")
    private WebElement loginInput;

    @FindBy(how = How.CSS, using = "#password")
    private  WebElement passwordInput;

    @FindBy(how = How.CSS, using = "#login2")
    private WebElement signInButton;

    /*method of logging to dms under supervisor*/

    public void loginToDMSUnderSupervisor(){
        /*public void inputText(WebElement webElement, String value){
            webElement.clear();
            webElement.sendKeys(value);
        }*/
        //waitForJSandJQueryToLoad();
        loginInput.clear();
        //loginInput.sendKeys(PropertyLoaderCredentials.loadProperty("loginValueSupervisor"));
        loginInput.sendKeys("andrey.bzhestovskyy@xloo.com");
        passwordInput.clear();
        //passwordInput.sendKeys(PropertyLoaderCredentials.loadProperty("passwordValueSupervisor"));
        passwordInput.sendKeys("andrey87");
        signInButton.click();
        //return PageFactory.initElements(driver, DmsMainPage.class);
    }

    /*method of logging to dms under manager*/
    public DmsMainPage loginToDMSUnderManager() {
        loginInput.clear();
        loginInput.sendKeys(PropertyLoaderCredentials.loadProperty("loginValueManager")); //login is taken from credentials.properties file
        passwordInput.clear();
        passwordInput.sendKeys(PropertyLoaderCredentials.loadProperty("passwordValueManager")); //password is taken from credentials.properties file
        signInButton.click();
        return PageFactory.initElements(driver, DmsMainPage.class);
    }

}
