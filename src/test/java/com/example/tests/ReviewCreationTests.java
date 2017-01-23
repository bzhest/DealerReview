package com.example.tests;


import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;


public class ReviewCreationTests extends TestBase {

    @AfterClass
    public void closeAllBrowsers() {
        app.getWebDriverHelper().driver.quit();
    }

    //Ниже указана логика работы теста
    @Test(priority = 1) //Этот тест будет выполняться первым
    public void reviewCanBeCreated() throws Exception {
        app.getNavigationHelper().fromHomePage_toDealerReviewForm();
        //app.getNavigationHelper();
        app.getNavigationHelper().switchToAnotherWindow();
        app.getFormHelper().fillAllFormFields(new FormFieldsObject("regdgv ergvset", "test_1@daxloo.com", "aaagaergearg", "Title for test1", "tae4ctergegvywrgsrh"));
        app.getFormHelper().markParametersWithStars("1", "4");
        app.getFormHelper().markParametersWithStars("3", "2");
        app.getFormHelper().markParametersWithStars("5", "5");
        app.getFormHelper().clickSubmit();
        app.webDriverHelper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-default.return")));
        app.getFormHelper().click_Return_OnOpenedModalWindow();

        //Проверку пока отключим
        /*Thread.sleep(1000);
        try {
            //Проверка, что на странице Dealer Review появилось новое ревью с тем названием, что прописывалось в форме
            assertEquals(driver.findElements(By.cssSelector(".col-lg-12.col-md-12.col-sm-12.col-xs-12>a")).get(0).getText(), "Title for test1");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }*/
        //app.driver.quit();
    }


    @Test(priority = 2) //Этот тест будет выполняться первым
    public void reviewFilledWithEmptyData() throws Exception {
        //Закрываем вторую вкладку браузера и переходим на первую
        app.getNavigationHelper().closeSecondTabAndGoToFirstTab();
        app.getNavigationHelper().fromHomePage_toDealerReviewForm();
        //Переходим с первой вкладки на вторую
        app.getNavigationHelper().switchToAnotherWindow();
        app.getFormHelper().fillAllFormFields(new FormFieldsObject("", "", "", "", ""));
        app.getFormHelper().clickSubmit();
    }








    /*
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }*/
}
