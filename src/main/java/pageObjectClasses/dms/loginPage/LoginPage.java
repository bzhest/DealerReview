package pageObjectClasses.dms.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.utilityProject.page.Page;
import utilities.utilityProject.properties.PropertyLoaderCredentials;


/**
 * Created by SYSTEM on 16.03.2017.
 */
public class LoginPage extends Page {

    public LoginPage(WebDriver driver){super(driver);}

    //Declare elements on a page
    @FindBy(how = How.CSS, using = "#login")
    private WebElement loginInput;

    //WebElement login = driver.findElement( By.cssSelector("#login") );

    @FindBy(how = How.CSS, using = "#password")
    private  WebElement passwordInput;

    @FindBy(how = How.CSS, using = "#login2")
    private WebElement signInButton;

    /*method of logging to dms under supervisor*/

    public void loginToDMSUnderSupervisor(){
        inputLoginPassword(PropertyLoaderCredentials.loadProperty("loginValueSupervisor"),PropertyLoaderCredentials.loadProperty("passwordValueSupervisor"));
        signInButton.click();
    }

    public void inputLoginPassword(String login, String password) {
        loginInput.clear();
        //loginInput.sendKeys(PropertyLoaderCredentials.loadProperty("loginValueSupervisor"));
        loginInput.sendKeys(login);
        passwordInput.clear();
        //passwordInput.sendKeys(PropertyLoaderCredentials.loadProperty("passwordValueSupervisor"));
        passwordInput.sendKeys(password);
    }

    /*method of logging to dms under manager*/
    /*public Home loginToDMSUnderManager() {
        loginInput.clear();
        loginInput.sendKeys(PropertyLoaderCredentials.loadProperty("loginValueManager")); //login is taken from credentials.properties file
        passwordInput.clear();
        passwordInput.sendKeys(PropertyLoaderCredentials.loadProperty("passwordValueManager")); //password is taken from credentials.properties file
        signInButton.click();
        return PageFactory.initElements(driver, Home.class);
    }*/

}
