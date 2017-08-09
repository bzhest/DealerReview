package utilityHelpers.windowHandlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by DWork on 16.06.2017.
 */
public class TestWindowHandles {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\DWork\\Desktop\\ExternalLink.html");
        driver.findElement(By.id("link")).click();
        WindowHandlers windowHandlers = new WindowHandlers(driver);
        windowHandlers.openSiteNewWindow("http://www.andreyb.ixloo.com");
        windowHandlers.switchToWindowByTitle("All righttt | Dealer Andrey");
        windowHandlers.switchToParentWindow();
        windowHandlers.closeExtraWindows();
        driver.quit();
    }
}
