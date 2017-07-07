package settings.users.userEditor.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by DWork on 07.07.2017.
 */
public class AddressTab {

    private WebDriver driver;

    public AddressTab(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(css = "address")
    WebElement address;

    @FindBy(css = "city_id")
    WebElement city;
}
