package com.example.managers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Andrey on 18.01.2017.
 */
public class HelperWithWebDriverBase {
    protected ApplicationManager manager;
    protected WebDriver driver;

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
}



//Здесь собраны низкоуровневые элементы typeTextInField, findElement - так делать правильно