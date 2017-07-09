package settings.users.userEditor.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Andrey on 08.07.2017.
 */
public class AccessTab {

    private WebDriver driver;

    public AccessTab(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getToolsItem() {
        return driver.findElement(By.xpath("//div[@class='access_group']/span[contains(text(), 'Tools')]"));
    }

    public WebElement getMap2Checkbox() {
        return driver.findElement(By.id("addon_make_a_page_2"));
    }
}
