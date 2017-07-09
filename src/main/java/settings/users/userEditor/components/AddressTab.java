package settings.users.userEditor.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.utils.javascript.Javascript;

import java.util.ArrayList;
import java.util.List;

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
    public String getCityText(){
        return driver.findElement(By.cssSelector("#city_id option[value =" + getCityOptionValue() + " ]")).getText();
    }

    public String getStateText(){
        return driver.findElement(By.cssSelector("#state_id option[value =" + getStateOptionValue() + " ]")).getText();
    }

    public String getCityOptionValue(){
        return Javascript.getElementText(driver,getCity());
    }
    public String getStateOptionValue(){
        return Javascript.getElementText(driver,getState());
    }
}
