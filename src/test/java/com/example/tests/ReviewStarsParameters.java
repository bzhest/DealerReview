package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by SYSTEM on 20.02.2017.
 */
public class ReviewStarsParameters extends TestBase {

    @BeforeClass(alwaysRun = true)
    public void loginToDMS() throws Exception {
        app.getWebDriverHelper().getDriver().get("http://www.solomia.andreyb.ixloo.com/" + "dms");
    }

    /**
     * Проверка, если параметры со звездочками не выставлены, то их нет и в самой форме*/

    @Test(enabled = false) //этот тест будет пропущен
    public void addNoneStarParameters() {
        app.getNavigationHelperDMS().openDMS();
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
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();

        List<WebElement> starNumberParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".starLabel"));
        Assert.assertEquals(starNumberParameter.size(),0);
    }

    /**
 * Проверяем, что выставленный параметр Your Overall Rating в DMS отображается и в DWS
 * и имеет 5 пустых звезд*/

        @Test (enabled = false)
        public void addYourOverallRatingParameter() {

            app.getNavigationHelperDMS().openDMS();
            WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
            // захожу на Landing page в Settings > Review
            toolsMenu.click();
            WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
            //кликаю на иконку Review
            ReviewImage.click();
            WebElement yourOverallRatingParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(0);
            List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
            //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

            for (int x=0; x<5; x++) {
                if (checkboxes.get(x).isSelected()) {
                    checkboxes.get(x).click();
                    app.getLoaderHelper().waitForJSandJQueryToLoad();
                }
            }
            //после того, как все чекбоксы сняты, выделяю чекбокс yourOverallRatingParameter
            yourOverallRatingParameter.click();
            WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
            //Сохраняю настройки
            buttonSave.click();app.getNavigationHelperDWS().openHomePage();
            app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
            app.getNavigationHelperDWS().switchToAnotherWindow(2);
            WebElement textForYourOverallRatingParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
            String text = textForYourOverallRatingParameter.getText().trim();
            Assert.assertEquals("Your Overall Rating", text);
            List <WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
            Assert.assertEquals(listOfEmptyStars.size(),5);
        }

    /**
     * Проверяем, что выставленный параметр Customer Service в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию) */

    @Test (enabled = false)
    public void addCustomerServiceParameter() {

        app.getNavigationHelperDMS().openDMS();
        WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
        // захожу на Landing page в Settings > Review
        toolsMenu.click();
        WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
        //кликаю на иконку Review
        ReviewImage.click();
        WebElement customerServiceParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(1);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x=0; x<5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс customerServiceParameter
        customerServiceParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textCustomerServiceParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textCustomerServiceParameter.getText().trim();
        Assert.assertEquals("Customer Service:", text);
        List <WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(),5);
    }

    /**
     * Проверяем, что выставленный параметр Buying Process  в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию) */

    @Test (enabled = false)
    public void addBuyingProcessParameter() {

        app.getNavigationHelperDMS().openDMS();
        WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
        // захожу на Landing page в Settings > Review
        toolsMenu.click();
        WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
        //кликаю на иконку Review
        ReviewImage.click();
        WebElement buyingProcessParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(2);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x=0; x<5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс buyingProcessParameter
        buyingProcessParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textBuyingProcessParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textBuyingProcessParameter.getText().trim();
        Assert.assertEquals("Buying Process:", text);
        List <WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(),5);
    }

    /**
     * Проверяем, что выставленный параметр Quality of Repair в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию) */

    @Test (enabled=false)
    public void addQualityOfRepairParameter() {

        app.getNavigationHelperDMS().openDMS();
        WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
        // захожу на Landing page в Settings > Review
        toolsMenu.click();
        WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
        //кликаю на иконку Review
        ReviewImage.click();
        WebElement customerServiceParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(3);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x=0; x<5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс customerServiceParameter
        customerServiceParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textQualityOfRepairParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textQualityOfRepairParameter.getText().trim();
        Assert.assertEquals("Quality of Repair:", text);
        List <WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(),5);
    }

    /**
     * Проверяем, что выставленный параметр Quality of Repair в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию) */

    @Test
    public void addOverallFacilitiesParameter() {

        app.getNavigationHelperDMS().openDMS();
        WebElement toolsMenu = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".v9-main-item.v9_sub")).get(4);
        // захожу на Landing page в Settings > Review
        toolsMenu.click();
        WebElement ReviewImage = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".big-module-item[href*='review-settings']"));
        //кликаю на иконку Review
        ReviewImage.click();
        WebElement overallFacilitiesParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(4);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x=0; x<5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс overallFacilitiesParameter
        overallFacilitiesParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textOverallFacilitiesParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textOverallFacilitiesParameter.getText().trim();
        Assert.assertEquals("Overall Facilities:", text);
        List <WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(),5);
    }

}




/*if(driver.findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null){
            waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }*/


//$("input[name*=4_visible]").attr('checked') если чекбокс отмечен, ставит true


