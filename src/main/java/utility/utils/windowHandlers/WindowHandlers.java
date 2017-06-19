package utility.utils.windowHandlers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by DWork on 16.06.2017.
 */
public class WindowHandlers {

    private WebDriver driver;
    private String parentWindowHandel;

    public WindowHandlers(WebDriver
                                  driver) {
        this.driver = driver;
        parentWindowHandel = driver.getWindowHandle();
    }

    //------------------------------------------------------------------------------------------------
    public static void switchToWindowByTitleStatic(WebDriver driver, String title) {
        Set<String> windows = driver.getWindowHandles();
        if (windows.size() < 2)
            throw new RuntimeException(" new window/tab wasn't opened");


        for (String windowHandals : windows) {
            if (driver.getTitle().equals(title))
                return;
        }
        throw new RuntimeException("No window with specified title");
    }
    //---------------------------------------------------------------------------------------------------

    public void switchToWindowByTitle(String title) {
        Set<String> windows = driver.getWindowHandles();
        if (windows.size() < 2)
            throw new RuntimeException(" new window/tab wasn't opened");


        for (String windowHandel : windows) {
            driver.switchTo().window(windowHandel);
            if (driver.getTitle().equals(title))
                return;
        }
        throw new RuntimeException("No window with specified title");
    }
    //----------------------------------------------------------------------------------------------------

    public void switchToParentWindow() {
        driver.switchTo().window(parentWindowHandel);
    }
    //----------------------------------------------------------------------------------------------------

    public void closeExtraWindows() {
        Set<String> windows = driver.getWindowHandles();
        for (String windowHandles : windows) {
            if (!windowHandles.equals(parentWindowHandel)) {
                driver.switchTo().window(windowHandles);
                driver.close();
            }
        }
    }
    //----------------------------------------------------------------------------------------------------

    public void openSiteNewWindow(String site){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + site + "','_blank');");
    }

    //----------------------------------------------------------------------------------------------------
}

