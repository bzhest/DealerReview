package usefull.exam.drivers.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Andrey on 02.07.2017.
 */
public class ControlPanel {
    private WebDriver driver;
    private WebDriverWait wait;

    public ControlPanel (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void clickButtonAdd() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qtip=\"Add\"]")));
            driver.findElement(By.cssSelector("button[data-qtip=\"Add\"]")).click();
        } catch (Exception ex) {
            throw new RuntimeException("Add button wasn't clicked ");
        }
    }

    public void clickButtonApply() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qtip=\"Apply\"]")));
            driver.findElement(By.cssSelector("button[data-qtip=\"Apply\"]")).click();
        } catch (Exception ex) {
            throw new RuntimeException("Apply button wasn't clicked ");
        }
    }

    public void clickButtonDelete() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qtip=\"Delete\"]")));
            driver.findElement(By.cssSelector("button[data-qtip=\"Delete\"]")).click();
        } catch (Exception ex) {
            throw new RuntimeException("Delete button wasn't clicked ");
        }
    }

    public void clickButtonAddInForm() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qtip=\"Add in form\"]")));
            driver.findElement(By.cssSelector("button[data-qtip=\"Add in form\"]")).click();
        } catch (Exception ex) {
            throw new RuntimeException("Add in Form button wasn't clicked ");
        }
    }

}
