package dealerList.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.Page;

/**
 * Created by DWork on 05.07.2017.
 */
public class ZipPopUp {

    protected WebDriver driver;

    public ZipPopUp(WebDriver driver){
        this.driver = driver;
    }

    public void buttonCloseClick() {
        driver.findElement(By.cssSelector("#dialog_search_close")).click();
    }
}
