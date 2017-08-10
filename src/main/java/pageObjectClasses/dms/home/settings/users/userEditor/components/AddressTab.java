package pageObjectClasses.dms.home.settings.users.userEditor.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.utilityHelpers.javascript.Javascript;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by DWork on 07.07.2017.
 */
public class AddressTab {

    private WebDriver driver;

    public AddressTab(WebDriver driver){
        this.driver = driver;
    }



    public WebElement getAddress() {
        return driver.findElement(By.id("address"));
    }

    public WebElement getCity() {
        return driver.findElement(By.id("city_id"));
    }

    public WebElement getState() {
        return driver.findElement(By.id("state_id"));
    }

    public String getAddressText(){
        return Javascript.getElementText(driver,getAddress());
    }
    /*public String getCityText(){
        return driver.findElement(By.cssSelector("#city_id option[value ='" +  getCityOptionValue() + "']")).getText();
    }*/

    public String getCityText(){
        Select select = new Select(driver.findElement(By.cssSelector("#city_id")));
        return select.getFirstSelectedOption().getText();
    }

    public String getStateText(){
        Select select = new Select(driver.findElement(By.cssSelector("#state_id")));
        return select.getFirstSelectedOption().getText();
    }

    public Integer getCityOptionValue(){
        return Integer.parseInt(Javascript.getElementText(driver,getCity()));
    }
    public Integer getStateOptionValue(){
        return Integer.parseInt(Javascript.getElementText(driver,getState()));
    }
}
