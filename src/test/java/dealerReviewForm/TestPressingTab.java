package dealerReviewForm;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by DWork on 11.07.2017.
 */
public class TestPressingTab {
    private WebDriver driver;
    private WebDriverWait wait;
    private Eyes eyes;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        eyes = new Eyes();
        eyes.setApiKey("42ocIyb2h7fn4sJyi0zODSOvI3glY118F26yVtRUB5c110");//(System.getenv("APPLITOOLS_API_KEY"));
        wait = new WebDriverWait(driver, 30);
        eyes.open(driver,"Dealer", "Login succeed2", new RectangleSize(1150, 650));
        driver.get("http://www.andreyb.ixloo.com/dms");

    }

    @Test
    public void succedded() {
        try{
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#login"))));
        eyes.checkWindow("Login");
        driver.findElement(By.cssSelector("#login")).clear();
        driver.findElement(By.cssSelector("#login")).sendKeys("dealerlogin");
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#password")).sendKeys("000");
        driver.findElement(By.cssSelector("#login2")).click();
        eyes.checkWindow("Logged in");
        Assert.assertEquals("Check if DMS is entered", driver.getCurrentUrl(), "http://www.andreyb.ixloo.com/dms");
        eyes.close();
        }catch(Exception ex){

        }
    }

    @AfterMethod
    public void teatDown() {
        eyes.abortIfNotClosed();
        driver.quit();
    }
}
