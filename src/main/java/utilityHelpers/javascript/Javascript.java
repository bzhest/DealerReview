package utilityHelpers.javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by DWork on 16.06.2017.
 */
public class Javascript {

    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
        //js.executeScript("document.querySelector('.mcprt-link').scrollIntoView()"); way with hardcoding
    }

    public static void clickOnElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", element);
    }

    public static String getElementText(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String)js.executeScript("return arguments[0].value", element);
    }
}


