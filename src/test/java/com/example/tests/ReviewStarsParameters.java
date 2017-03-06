package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
     * Проверка, если параметры со звездочками не выставлены, то их нет и в самой форме
     */

    @Test(enabled = false) //этот тест будет пропущен
    public void addNoneStarParameters() {
        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        //Получаю список чекбоксов на странице
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение
        for (int x = 0; x < 5; x++) {
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
        Assert.assertEquals(starNumberParameter.size(), 0);
    }

    /**
     * Проверяем, что выставленный параметр Your Overall Rating в DMS отображается и в DWS
     * и имеет 5 пустых звезд
     */

    @Test(enabled = false)
    public void addYourOverallRatingParameter() {

        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        WebElement yourOverallRatingParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(0);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x = 0; x < 5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс yourOverallRatingParameter
        yourOverallRatingParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textForYourOverallRatingParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textForYourOverallRatingParameter.getText().trim();
        Assert.assertEquals("Your Overall Rating", text);
        List<WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(), 5);
    }

    /**
     * Проверяем, что выставленный параметр Customer Service в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию)
     */

    @Test(enabled = false)
    public void addCustomerServiceParameter() {

        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        WebElement customerServiceParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(1);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x = 0; x < 5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс customerServiceParameter
        customerServiceParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textCustomerServiceParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textCustomerServiceParameter.getText().trim();
        Assert.assertEquals("Customer Service:", text);
        List<WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(), 5);
    }

    /**
     * Проверяем, что выставленный параметр Buying Process  в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию)
     */

    @Test(enabled = false)
    public void addBuyingProcessParameter() {

        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        WebElement buyingProcessParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(2);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x = 0; x < 5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс buyingProcessParameter
        buyingProcessParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textBuyingProcessParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textBuyingProcessParameter.getText().trim();
        Assert.assertEquals("Buying Process:", text);
        List<WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(), 5);
    }

    /**
     * Проверяем, что выставленный параметр Quality of Repair в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию)
     */

    @Test(enabled = false)
    public void addQualityOfRepairParameter() {

        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        WebElement qualityOfRepairParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(3);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x = 0; x < 5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс customerServiceParameter
        qualityOfRepairParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textQualityOfRepairParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textQualityOfRepairParameter.getText().trim();
        Assert.assertEquals("Quality of Repair:", text);
        List<WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(), 5);
    }

    /**
     * Проверяем, что выставленный параметр Quality of Repair в DMS
     * отображается и в DWS (и имеет 5 пустых звезд по умолчанию)
     */

    @Test(enabled = false)
    public void addOverallFacilitiesParameter() {

        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        WebElement overallFacilitiesParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(4);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x = 0; x < 5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс overallFacilitiesParameter
        overallFacilitiesParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        WebElement textOverallFacilitiesParameter = app.getWebDriverHelper().getDriver().findElement(By.cssSelector(".starLabel"));
        String text = textOverallFacilitiesParameter.getText().trim();
        Assert.assertEquals("Overall Facilities:", text);
        List<WebElement> listOfEmptyStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfEmptyStars.size(), 5);
    }

    @Test (enabled = false)
    public void addAllFiveParameter() {

        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        WebElement yourOverallRatingParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(0);
        WebElement customerServiceParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(1);
        WebElement buyingProcessParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(2);
        WebElement qualityOfRepairParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(3);
        WebElement overallFacilitiesParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(4);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x = 0; x < 5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс overallFacilitiesParameter
        yourOverallRatingParameter.click();
        customerServiceParameter.click();
        buyingProcessParameter.click();
        qualityOfRepairParameter.click();
        overallFacilitiesParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        List <WebElement> parametersArrays = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".starLabel"));
        Assert.assertEquals(parametersArrays.size(), 5);
        List<WebElement> listOfStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfStars.size(), 25);
    }

    @Test
    public void addAllFiveParametersMarkFiveParametersWithFiveStars() {

        app.getNavigationHelperDMS().openDealershipReviewSettingsPage();
        WebElement yourOverallRatingParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(0);
        WebElement customerServiceParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(1);
        WebElement buyingProcessParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(2);
        WebElement qualityOfRepairParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(3);
        WebElement overallFacilitiesParameter = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]")).get(4);
        List<WebElement> checkboxes = app.getWebDriverHelper().getDriver().findElements(By.cssSelector("input[name*=_visible]"));
        //Прохожу по всем чекбоксам, если чекбокс отмечен - снимаем выделение

        for (int x = 0; x < 5; x++) {
            if (checkboxes.get(x).isSelected()) {
                checkboxes.get(x).click();
                app.getLoaderHelper().waitForJSandJQueryToLoad();
            }
        }
        //после того, как все чекбоксы сняты, выделяю чекбокс overallFacilitiesParameter
        yourOverallRatingParameter.click();
        customerServiceParameter.click();
        buyingProcessParameter.click();
        qualityOfRepairParameter.click();
        overallFacilitiesParameter.click();
        WebElement buttonSave = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".sp")).get(0);
        //Сохраняю настройки
        buttonSave.click();
        app.getNavigationHelperDWS().openHomePage();
        app.getNavigationHelperDWS().fromHomePage_toDealerReviewForm();
        app.getNavigationHelperDWS().switchToAnotherWindow(2);
        FormFieldsObject form = new FormFieldsObject()
                .setNickname("Vasia")
                .setEmail("autotest@dxloo.com")
                .setLocation("Dnipro")
                .setReviewTitle("some title")
                .setReviewText("some text");
        app.getFormHelper().fillAllFormFields(form);
        //Нахожу звезду по xpath,
        selectStar("1", "0.5");
        selectStar("2", "1");
        selectStar("3", "1.5");
        selectStar("4", "2");
        selectStar("5", "2.5");
        /*классы звезд
        * fa fa-star-o - пустая звезда
        * fa fa-star-half-o - ползвезды
        * fa fa-star - целая звезда*/
        /*js.executeScript("document.getElementById('//id of element').setAttribute('attr', '10')");
        document.getElementById("MyElement").className = "MyClass";*/


        //app.getFormHelper().markParametersWithStars("1","5");
        //app.getFormHelper().markParametersWithStars("3","5");
        app.getFormHelper().clickSubmit();
        app.webDriverHelper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-default.return")));
        app.getFormHelper().click_Return_OnOpenedModalWindow();
        /*List <WebElement> parametersArrays = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".starLabel"));
        Assert.assertEquals(parametersArrays.size(), 5);
        List<WebElement> listOfStars = app.getWebDriverHelper().getDriver().findElements(By.cssSelector(".fa.fa-star-o"));
        Assert.assertEquals(listOfStars.size(), 25);*/
    }

    public void selectStar(final String paramNumber, String starNumber) {

    /*WebElement star = app.getWebDriverHelper().getDriver().findElement(By.xpath("//div[@class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 full-width-in-thin\"]/div[@class=\"form-control-static row\"][" + paramNumber + "]//span[@class=\"stars\"]/i[@class=\"fa fa-star-o\"][" + starNumber + "]"));
        JavascriptExecutor js = (JavascriptExecutor) app.getWebDriverHelper().getDriver();
        js.executeScript("arguments[0].className = 'fa fa-star'", star);
        for (int i = 0; i< Integer.parseInt(starNumber); i++){

        }*/

        double d= Double.valueOf(starNumber);
        if (d==(int)d){
            //Если starNumber - єто Intager, то наведение курсора на звезду со сдвигом право (получение целой звезди)
            WebElement star = app.getWebDriverHelper().getDriver().findElement(By.xpath("//div[@class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 full-width-in-thin\"]/div[@class=\"form-control-static row\"][" + paramNumber + "]//span[@class=\"stars\"]/i[@class=\"fa fa-star-o\"][" + starNumber + "]"));
            int width = star.getSize().getWidth();
            Actions act = new Actions(app.getWebDriverHelper().getDriver());
            act.moveToElement(star).moveByOffset((width/2)-2, 0).click().perform();
        }else{
            //Если starNumber - єто Double, то наведение курсора на звезду со сдвигом влево (получение половины звезди)
            starNumber = "" + (int)(Double.parseDouble(starNumber)+0.5);
            WebElement star1 = app.getWebDriverHelper().getDriver().findElement(By.xpath("//div[@class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 full-width-in-thin\"]/div[@class=\"form-control-static row\"][" + paramNumber + "]//span[@class=\"stars\"]/i[@class=\"fa fa-star-o\"][" + starNumber + "]"));
            int width = star1.getSize().getWidth();
            Actions act = new Actions(app.getWebDriverHelper().getDriver());
            act.moveToElement(star1).moveByOffset((width/2)-8, 0).click().perform();
        }
    /*//Наведение курсора на звезду со сдвигом влево (получение ползвезды)
        WebElement star = app.getWebDriverHelper().getDriver().findElement(By.xpath("//div[@class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 full-width-in-thin\"]/div[@class=\"form-control-static row\"][" + paramNumber + "]//span[@class=\"stars\"]/i[@class=\"fa fa-star-o\"][" + starNumber + "]"));
        int width = star.getSize().getWidth();
        Actions act = new Actions(app.getWebDriverHelper().getDriver());
        act.moveToElement(star).moveByOffset((width/2)-6, 0).click().perform();*/

        /*//Наведение курсора на звезду со сдвигом право (получение целой звезди)
        WebElement star = app.getWebDriverHelper().getDriver().findElement(By.xpath("//div[@class=\"col-lg-6 col-md-6 col-sm-12 col-xs-12 full-width-in-thin\"]/div[@class=\"form-control-static row\"][" + paramNumber + "]//span[@class=\"stars\"]/i[@class=\"fa fa-star-o\"][" + starNumber + "]"));
        int width = star.getSize().getWidth();
        Actions act = new Actions(app.getWebDriverHelper().getDriver());
        act.moveToElement(star).moveByOffset((width/2)+2, 0).click().perform();*/
    }

}






/*if(driver.findElement(By.cssSelector("#addon_make_a_page_2")).getAttribute("checked") == null){
            waitForJSandJQueryToLoad();
            driver.findElement(By.cssSelector("#addon_make_a_page_2")).click();
        }*/


//$("input[name*=4_visible]").attr('checked') если чекбокс отмечен, ставит true


