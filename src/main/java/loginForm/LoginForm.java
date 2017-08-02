package loginForm;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.Page;

/**
 * Created by Andrey on 02.08.2017.
 */
@Getter
public class LoginForm extends Page {

    public LoginForm (WebDriver driver){super(driver);}

    @FindBy
    WebElement login;

    @FindBy
    WebElement password;

    @FindBy(css = ".login_submit_btn")
    WebElement submitButton;

    @FindBy(css = ".dws_logout_form_submit")
    WebElement logOutFormButton;


    public void inputLoginPassword(String login, String password) {
        getLogin().clear();
        //loginInput.sendKeys(PropertyLoaderCredentials.loadProperty("loginValueSupervisor"));
        getLogin().sendKeys(login);
        getPassword().clear();
        //passwordInput.sendKeys(PropertyLoaderCredentials.loadProperty("passwordValueSupervisor"));
        getPassword().sendKeys(password);
        submitButton.click();
    }
}
