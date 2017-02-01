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
        app.getNavigationHelper().fromHomePageGoToDealerReviewPage();
        //Получения группы Тайтлов до теста
         Set <FormFieldsObject> oldList = app.getFormHelper().getReviewsTitles();
        //Действия
        app.getNavigationHelper().onDealerReviewPageClick_AddReview();
        app.getNavigationHelper().switchToAnotherWindow(2);
        FormFieldsObject validForm = new FormFieldsObject()
                .setNickname("regdgv ergvset").setEmail("test_1@daxloo.com").setLocation("aaagaergearg").setReviewTitle("Title for test1").setReviewText("tae4ctergegvywrgsrh");
        app.getFormHelper().fillAllFormFields(validForm);
        app.getFormHelper().markParametersWithStars("1", "4");
        app.getFormHelper().markParametersWithStars("3", "2");
        app.getFormHelper().markParametersWithStars("5", "5");
        app.getFormHelper().clickSubmit();
        app.webDriverHelper.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-default.return")));
        app.getFormHelper().click_Return_OnOpenedModalWindow();
        //Получения группы Тайтлов после теста
        Set <FormFieldsObject> newList = app.getFormHelper().getReviewsTitles();
        verifyReviewAdded(oldList, validForm, newList);


    }

    private void verifyReviewAdded(Set<FormFieldsObject> oldList, FormFieldsObject validForm, Set<FormFieldsObject> newList) {


    }


    @Test(priority = 2) //Этот тест будет выполняться первым
    public void reviewFilledWithEmptyData() throws Exception {
        //Закрываем вторую вкладку браузера и переходим на первую
        app.getNavigationHelper().switchToAnotherWindow(2);
        app.getNavigationHelper().closeSecondTabAndGoToFirstTab();
        app.getNavigationHelper().fromHomePage_toDealerReviewForm();
        //Переходим с первой вкладки на вторую
        app.getNavigationHelper().switchToAnotherWindow(1);
        FormFieldsObject emptyForm = new FormFieldsObject()
                .setNickname("").setEmail("").setLocation("").setReviewTitle("").setReviewText("");
        app.getFormHelper().fillAllFormFields(emptyForm);
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
