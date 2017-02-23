package com.example.tests;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by SYSTEM on 20.02.2017.
 */
public class ReviewStarsParameters extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void loginToDMS() throws Exception {
        app.getWebDriverHelper().getDriver().get("http://www.solomia.andreyb.ixloo.com/" + "dms/login");
    }

    //Проверка, если параметры со звездочками не выставлены, их нет и в самой форме
    @Test//(enabled = false) //этот тест будет пропущен
    public void addNoneStarParameters() {
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
        app.getNavigationHelper().openHomePage();
        app.getNavigationHelper().fromHomePage_toDealerReviewForm();

        List<WebElement> starNumberParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".starLabel"));
        Assert.assertEquals(starNumberParameter.size(),0);
    }


        @Test
        public void addYourOverallRatingParameter() {

            app.getNavigationHelper().closeSecondTabAndGoToFirstTab();
            app.getWebDriverHelper().getDriver().get(app.getWebDriverHelper().baseUrl + "dms");
            String url = app.getWebDriverHelper().getDriver().getCurrentUrl();
            //Если при переходе в DMS оказывается, что я не залогинен - я логинюсь
            if(url == app.getWebDriverHelper().baseUrl + "dms/login")
            {
                app.getFormHelper().loginToDMS("andrey.bzhestovskyy@xloo.com", "#login", "andrey87", "#password");
            }
            WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
            // захожу на Landing page в Settings > Review
            toolsMenu.click();
            WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
            //кликаю на иконку Review
            ReviewImage.click();
            WebElement YourOverallRatingParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector("input[name*=0_visible]"));
            List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
            //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение
            if ( !YourOverallRatingParameter.isSelected() )
            {
                YourOverallRatingParameter.click();
            }
            for (int x=0; x<5; x++) {
                if (checkboxes.get(x).isSelected() && checkboxes.get(x)!=YourOverallRatingParameter) {
                    checkboxes.get(x).click();
                    app.getLoaderHelper().waitForJSandJQueryToLoad();
                }

            }
        }

}




/*if(driver.findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null){
            waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }*/


//$("input[name*=4_visible]").attr('checked') если чекбокс отмечен, ставит true
