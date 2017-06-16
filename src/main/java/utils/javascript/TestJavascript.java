package utils.javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by DWork on 16.06.2017.
 */
public class TestJavascript {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get ("http://www.andreyb.ixloo.com/Inventory-test1_items_10_page_7.html");
        WebElement link = driver.findElement(By.cssSelector(".mcprt-link"));
        Javascript.scrollToElement(driver, link);

    }
}
