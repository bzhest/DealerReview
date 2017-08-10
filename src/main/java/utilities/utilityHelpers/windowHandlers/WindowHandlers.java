package utilities.utilityHelpers.windowHandlers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by DWork on 16.06.2017.
 */
public class WindowHandlers {

    private WebDriver driver;
    private String parentWindowHandel;

    public WindowHandlers(WebDriver driver) {
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

    public void openSiteNewWindow(String site) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + site + "','_blank');");
    }

    //----------------------------------------------------------------------------------------------------

    public void switchToAnotherWindow(int winNumber) {
        Set allWindowHandles = driver.getWindowHandles();// возвращает набор дискрипторов окон
        String neededWindow = (String) allWindowHandles.toArray()[winNumber - 1];
        driver.switchTo().window(neededWindow);
    }
    //------------------------------------------------------------------------------------------------------
    public static void switchToCertainWindow(WebDriver driver, Integer windowNumber){
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(windowNumber));
    }
    //-----------------------------------------------------------------------------------------------------

    public static void acceptAlert(WebDriver driver) {
        {
            try {
                //(new WebDriverWait(driver, 10)).until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
            } catch (NoAlertPresentException e) {
                // nothing will do, because alert not appeared
            }
        }
    }

    //-----------------------------------------------------------------------------------------------------
    public static void dismissAlert(WebDriver driver) {
        try {
            //(new WebDriverWait(driver, 10)).until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            // nothing will do, because alert not appeared
        }
    }
}

