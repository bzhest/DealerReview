package dealerList.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Page;

/**
 * Created by DWork on 05.07.2017.
 */
public class ZipPopUp extends Page {

    @FindBy(css = "#dialog_search_close")
    WebElement closeButton;


    public ZipPopUp(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    public void buttonCloseClick() {
        wait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();
    }
}
