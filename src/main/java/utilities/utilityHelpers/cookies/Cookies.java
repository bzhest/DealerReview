package utilities.utilityHelpers.cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.utilityProject.testBase.TestBase;

import java.util.Set;

/**
 * Created by Andrey on 25.06.2017.
 */
public class Cookies extends TestBase {


    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.get("http://www.andreyb.ixloo.com/dms");
        driver.findElement(By.cssSelector("#login")).clear();
        driver.findElement(By.cssSelector("#login")).sendKeys("andrey.bzhestovskyy@xloo.com");
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#password")).sendKeys("andrey87");
        driver.findElement(By.cssSelector("#login2")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".dealer_name.notranslate"))));
        System.out.println( "After click 'Submit' cookies are: " + driver.manage().getCookies());
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.manage().deleteAllCookies();
        driver.get("http://www.andreyb.ixloo.com/dms");
        driver.manage().deleteCookieNamed("PHPSESSID");
        for (Cookie cookie: cookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
        System.out.println("after refresh" + driver.manage().getCookies());
    }

    public static Set<Cookie> saveCookies(WebDriver driver){
        return driver.manage().getCookies();
    }

    public static void makeLogOut(WebDriver driver){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    public static void enterIntoSession(WebDriver driver, Set<Cookie> cookies){
        driver.manage().deleteCookieNamed("PHPSESSID");
        for (Cookie cookie: cookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }
}
