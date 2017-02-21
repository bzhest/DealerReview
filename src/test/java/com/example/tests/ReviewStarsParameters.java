package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;

/**
 * Created by SYSTEM on 20.02.2017.
 */
public class ReviewStarsParameters extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void loginToDMS() throws Exception {
        app.getWebDriverHelper().getDriver().get("http://www.solomia.andreyb.ixloo.com/" + "dms/login");
    }


    @Test//(enabled = false) //этот тест будет пропущен
    public void addOneStarParameter() {
        app.getFormHelper().loginToDMS("andrey.bzhestovskyy@xloo.com", "#login", "andrey87", "#password");
        WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
        // захожу на Landing page в Settings > Review
        toolsMenu.click();
        WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
        //кликаю на иконку Review
        ReviewImage.click();
        //Получаю список чекбоксов на странице
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение
        for (int x=0; x<5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        app.getLoaderHelper().waitForJSandJQueryToLoad();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();


    }
}

//Boolean isPresent = driver.findElements(By.yourLocator).size() > 0
