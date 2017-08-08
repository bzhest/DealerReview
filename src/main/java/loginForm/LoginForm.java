package loginForm;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Page;

/**
 * Created by Andrey on 02.08.2017.
 */
@Getter
public class LoginForm extends Page {
    WebDriverWait wait;

    public LoginForm (WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver,10);
    }

    @FindBy(css = "input[name='login']")
    WebElement login;

    @FindBy(css = "input[name='password']")
    WebElement password;

    @FindBy(css = ".login_submit_btn")
    WebElement loginButton;

    @FindBy(css = ".dws_logout_form>button")
    WebElement logOutFormButton;


    public void inputLoginPassword(String login, String password) {
        sleep(1);
        try {
            if(!logOutFormButton.isDisplayed()){
                inputText(getLogin(),login);
                inputText(getPassword(), password);
                loginButton.click();

            }else{
                logOutFormButton.click();
                inputText(getLogin(),login);
                inputText(getPassword(), password);
                loginButton.click();

            }
        }catch(RuntimeException er){
            System.out.println("User can't be logged in");
        }
    }

    public void inputText(WebElement el, String text){
        el.clear();
        el.sendKeys(text);
    }
}
