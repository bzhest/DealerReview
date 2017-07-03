package utility.utils.exam.drivers.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrey on 02.07.2017.
 */
public class Confirmation {

    private WebDriver driver;
    private WebDriverWait wait;

    public Confirmation (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    public void clickButtonYes() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[style=\"margin: 0px; width: 75px; left: 36px; top: 0px;\"]")));
            driver.findElement(By.cssSelector("div[style=\"margin: 0px; width: 75px; left: 36px; top: 0px;\"]")).click();
        } catch (Exception ex) {
            throw new RuntimeException("Yes button wasn't clicked ");
        }
    }

    public void clickButtonNo() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[style=\"margin: 0px; width: 75px; left: 117px; top: 0px;\"]")));
            driver.findElement(By.cssSelector("div[style=\"margin: 0px; width: 75px; left: 117px; top: 0px;\"]")).click();
        } catch (Exception ex) {
            throw new RuntimeException("No button wasn't clicked ");
        }
    }

}
