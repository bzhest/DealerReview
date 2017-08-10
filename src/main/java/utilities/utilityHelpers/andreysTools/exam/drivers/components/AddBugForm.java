package utilities.utilityHelpers.andreysTools.exam.drivers.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrey on 02.07.2017.
 */
public class AddBugForm {

    private WebDriver driver;
    private WebDriverWait wait;

    public AddBugForm(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    private void inputText(String locator, String text){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    public void clickButtonOk() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qtip=\"OK\"]")));
            driver.findElement(By.cssSelector("button[data-qtip=\"OK\"]")).click();
        } catch (Exception ex) {
            throw new RuntimeException("button Ok wasn't clicked");
        }
    }

    public void clickButtonCancel() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qtip=\"Cancel\"]")));
            driver.findElement(By.cssSelector("button[data-qtip=\"Cancel\"]"));
        } catch (Exception ex) {
            throw new RuntimeException("button Cancel wasn't clicked");
        }
    }

    public void fillFieldName(String text) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=\"name\"]")));
            inputText("input[name=\"name\"]",text);
        } catch (Exception ex) {
            throw new RuntimeException("name wasn't added");
        }
    }

    public void fillFieldNotes(String text) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea[name=\"notes\"]")));
            inputText("textarea[name=\"notes\"]",text);
        } catch (Exception ex) {
            throw new RuntimeException("notes wasn't added");
        }
    }


}
