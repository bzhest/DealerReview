package com.example.managers;

import com.example.logHelper.FileLogger;
import com.example.logHelper.LogBase;
import com.example.logHelper.StdLogger;
import com.example.tests.FormFieldsObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.example.tests.TestBase.getLogger;

/**
 * Created by Andrey on 18.01.2017.
 */
public class HelperWithWebDriverBase {
    protected ApplicationManager manager;
    protected WebDriver driver;
    LogBase logger = getLogger("File");





    // в качестве параметра конструктору передаем ссылку на начальника - ApplicationManager, чтобы HelperWithWebDriverBase знал о нем
    public HelperWithWebDriverBase(ApplicationManager manager){
        this.manager = manager;
        driver = manager.getWebDriverHelper().getDriver();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void typeTextInField(String nickname, String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(nickname);
    }

    public WebElement findElement(By selector) {
        return driver.findElement(selector);
    }

    public List<WebElement> findElements(By selector) {
        return driver.findElements(selector);
    }

    public static LogBase getLogger(String type){
        return type.equals("File") ? new FileLogger() : new StdLogger();
    }
}



//Здесь собраны низкоуровневые элементы typeTextInField, findElement - так делать правильно