package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.Set;

/**
 * Created by SYSTEM on 20.02.2017.
 */
public class ReviewStarsParameters extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void loginToDMS() throws Exception {
        app.getWebDriverHelper().getDriver().get("http://www.solomia.andreyb.ixloo.com/" + "dms/login");
    }


    @Test(enabled = false) //этот тест будет выполняться первым
    public void addOneStarParameter() {
        app.getFormHelper().loginToDMS("andrey.bzhestovskyy@xloo.com", "#login", "andrey87", "#password");
        WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
        toolsMenu.click();
        WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
        ReviewImage.click();
        if(app.getWebDriverHelper().getDriver().findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null){
            app.getLoaderHelper().waitForJSandJQueryToLoad();
            app.getWebDriverHelper().getDriver().findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }
    }
}

//Boolean isPresent = driver.findElements(By.yourLocator).size() > 0
