package dealerReviewForm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.browser.api.WebDriverManager;
import utility.browser.users.DefaultWebDriverManager;

/**
 * Created by DWork on 11.07.2017.
 */
public class testPressingTab {
    WebDriver driver;

    @BeforeMethod
    protected void beforeTest() {
        WebDriverManager wdm = new DefaultWebDriverManager();
        driver = wdm.getWebDriver();
        driver.get("http://www.solomia.andreyb.ixloo.com/dealer-review-form_solomia-vasilivna__user_14187_site_6287.html");
    }

    @Test
    public void firstClickTab(){
        driver.getKeyboard().
    }
}
