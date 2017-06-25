package utility.utils.cookies;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.base.TestBase;

import java.util.Set;

/**
 * Created by Andrey on 25.06.2017.
 */
public class Cookies extends TestBase {
    WebDriverWait wait;


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://lms.it-hillel.com.ua/login/index.php");
        driver.findElement(By.cssSelector("#username")).clear();
        driver.findElement(By.cssSelector("#username")).sendKeys("bzhest@gmail.com");
        driver.findElement(By.cssSelector("#password")).clear();
        driver.findElement(By.cssSelector("#password")).sendKeys("NMetAY01");
        driver.findElement(By.cssSelector("#loginbtn")).click();
        System.out.println( "after click Submit" + driver.manage().getCookies());
        Set<Cookie> cookies = driver.manage().getCookies();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        for (Cookie cookie: cookies){
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
        System.out.println("after refresh" + driver.manage().getCookies());
    }
}
