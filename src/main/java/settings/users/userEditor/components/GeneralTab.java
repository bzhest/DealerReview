package settings.users.userEditor.components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utility.utils.javascript.Javascript;

/**
 * Created by DWork on 07.07.2017.
 */
public class GeneralTab {

    protected WebDriver driver;

    public GeneralTab(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#user_contact")
    WebElement firstName;

    @FindBy(css = "#user_contact2")
    WebElement lastName;

    public String getFirstName() {
        return Javascript.getElementText(driver,firstName);
    }

    public String getLastName() {
        return Javascript.getElementText(driver,lastName);
    }

}
